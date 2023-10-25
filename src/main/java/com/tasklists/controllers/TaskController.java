package com.tasklists.controllers;

import com.tasklists.domain.task.Task;
import com.tasklists.dtos.TaskDTO;
import com.tasklists.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO data) throws Exception{
        Task newTask = this.service.createTask(data);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }
}
