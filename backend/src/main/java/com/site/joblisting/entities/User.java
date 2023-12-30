package com.site.joblisting.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

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

    public User(int userId, String userName, String userPwd, String userEmail, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail
                + ", userRole=" + userRole + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(userPwd, user.userPwd) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userRole, user.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPwd, userEmail, userRole);
    }
}
