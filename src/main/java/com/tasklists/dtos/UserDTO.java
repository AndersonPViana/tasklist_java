package com.tasklists.dtos;

import com.tasklists.domain.user.UserRole;

public record UserDTO(String firstName, String lastName, String email, String password, UserRole role) {
}
