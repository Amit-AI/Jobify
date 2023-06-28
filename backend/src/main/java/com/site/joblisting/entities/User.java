package com.site.joblisting.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail
                + ", userRole=" + userRole + "]";
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

}
