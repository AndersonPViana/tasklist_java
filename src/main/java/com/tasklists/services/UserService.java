package com.tasklists.services;

import com.tasklists.domain.user.User;
import com.tasklists.dtos.UserDTO;
import com.tasklists.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.repository.save(newUser);
        return newUser;
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public UserDetails findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

}
