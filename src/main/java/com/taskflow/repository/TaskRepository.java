package com.taskflow.repository;

import com.taskflow.model.Task;
import com.taskflow.model.Task.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findByStatus(TaskStatus status, Pageable pageable);
    List<Task> findByAssigneeId(Long assigneeId);

    @Query("SELECT t FROM Task t WHERE (:status IS NULL OR t.status = :status) " +
           "AND (:assigneeId IS NULL OR t.assignee.id = :assigneeId)")
    Page<Task> findFilteredTasks(@Param("status") TaskStatus status, 
                                 @Param("assigneeId") Long assigneeId, 
                                 Pageable pageable);
}
