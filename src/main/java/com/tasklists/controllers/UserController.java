package com.tasklists.controllers;

import com.tasklists.domain.user.User;
import com.tasklists.dtos.UserDTO;
import com.tasklists.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = this.userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) throws Exception {
        User user = this.userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
