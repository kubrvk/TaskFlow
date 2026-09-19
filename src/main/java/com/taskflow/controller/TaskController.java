package com.taskflow.controller;

import com.taskflow.model.Task;
import com.taskflow.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Page<Task>> listTasks(
            @RequestParam(required = false) Task.TaskStatus status,
            @RequestParam(required = false) Long assigneeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "updatedAt") String sortBy) {

        Page<Task> tasks = taskService.getTasks(status, assigneeId, 
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortBy)));
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Principal principal) {
        String username = (principal != null) ? principal.getName() : "system";
        return ResponseEntity.ok(taskService.createTask(task, username));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(
            @PathVariable Long id, 
            @RequestParam Task.TaskStatus status,
            Principal principal) {
        String username = (principal != null) ? principal.getName() : "system";
        return ResponseEntity.ok(taskService.updateStatus(id, status, username));
    }
}
