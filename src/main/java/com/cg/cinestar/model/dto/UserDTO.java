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


    public UserDTO(Long id, String username, String fullName, String phone, String email, String address, String dateOfBirth, Status status, Role role) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.role = role;
    }

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
