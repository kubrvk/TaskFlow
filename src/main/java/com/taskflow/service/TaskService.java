package com.taskflow.service;

import com.taskflow.model.Task;
import com.taskflow.model.AuditLog;
import com.taskflow.repository.TaskRepository;
import com.taskflow.repository.AuditLogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final AuditLogRepository auditLogRepository;

    public TaskService(TaskRepository taskRepository, AuditLogRepository auditLogRepository) {
        this.taskRepository = taskRepository;
        this.auditLogRepository = auditLogRepository;
    }

    public Page<Task> getTasks(Task.TaskStatus status, Long assigneeId, Pageable pageable) {
        return taskRepository.findFilteredTasks(status, assigneeId, pageable);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
    }

    @Transactional
    public Task createTask(Task task, String creatorUsername) {
        Task saved = taskRepository.save(task);
        auditLogRepository.save(AuditLog.builder()
                .action("TASK_CREATED")
                .entityName("Task")
                .entityId(saved.getId())
                .performedBy(creatorUsername)
                .details("Created task: " + saved.getTitle())
                .build());
        return saved;
    }

    @Transactional
    public Task updateStatus(Long id, Task.TaskStatus newStatus, String actorUsername) {
        Task task = getTaskById(id);
        Task.TaskStatus oldStatus = task.getStatus();
        task.setStatus(newStatus);
        Task updated = taskRepository.save(task);

        auditLogRepository.save(AuditLog.builder()
                .action("TASK_STATUS_CHANGED")
                .entityName("Task")
                .entityId(updated.getId())
                .performedBy(actorUsername)
                .details(String.format("Status transition from %s to %s", oldStatus, newStatus))
                .build());
        return updated;
    }
}
