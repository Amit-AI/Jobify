package com.site.joblisting.dao;

import java.util.List;

import com.site.joblisting.entities.Job;

public interface JobDao {
    
    public List<Job> getAllPostedJobs();
    public Job getJob(int id);
    public void insertJob(Job job);
    public void updateJob(int id, Job job);
    public void deleteJob(int id);
}
