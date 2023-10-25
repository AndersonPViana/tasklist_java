package com.tasklists.repositories;

import com.tasklists.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
