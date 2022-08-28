package com.cg.cinestar.model.dto;

import com.cg.cinestar.model.Role;
import com.cg.cinestar.model.Status;
import com.cg.cinestar.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)

public class UserDTO {
    private Long id;

    private String username;

    private String password;

    private String fullName;

    private String phone;

    private String email;

    private String address;

    private String dateOfBirth;

    private Status status;

    private Role role;

    public User toUser() {
        return new User()
                .setUsername(username)
                .setPassword(password)
                .setFullName(fullName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDateOfBirth(dateOfBirth)
                .setStatus(status)
                .setRole(role);
    }
}
