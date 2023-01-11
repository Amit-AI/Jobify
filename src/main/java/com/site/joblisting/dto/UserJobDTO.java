package com.site.joblisting.dto;

import java.util.List;

import com.site.joblisting.entities.Job;

public class UserJobDTO {

    private String userName;
    private List<Job> jobs;
    
    public String getUserName() {
        return userName;
    }
    public UserJobDTO(String userName, List<Job> jobs) {
        this.userName = userName;
        this.jobs = jobs;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<Job> getJobs() {
        return jobs;
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    
}
