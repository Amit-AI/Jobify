package com.site.joblisting.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotEmpty(message = "Username could not be empty or null")
    @Size(min = 4, message = "Username could not be less than 4 characters")
    @Column(nullable = false)
    private String userName;

    @NotEmpty(message = "Password could not be empty or null")
    @Column(nullable = false)
    @Size(min = 4, message = "Password could not be less than 4 characters")
    private String userPwd;


    @NotEmpty(message = "Email could not be empty or null.")
    @Email(message = "Invalid Email address.")
    @Column(nullable = false)
    private String userEmail;


    @NotEmpty(message = "Role could not be empty or null.")
    @Column(nullable = false)
    private String userRole;
}
