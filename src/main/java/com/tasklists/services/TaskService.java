package com.tasklists.services;

import com.tasklists.domain.task.Task;
import com.tasklists.domain.user.User;
import com.tasklists.dtos.TaskDTO;
import com.tasklists.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserService userService;

    public Task createTask(TaskDTO data) throws Exception {
        User user = userService.findUserById(data.userId());

        Task newTask = new Task();
        newTask.setName(data.name());
        newTask.setState(data.state());
        newTask.setUser(user);

        this.repository.save(newTask);

        return newTask;
    }
}
