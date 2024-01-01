package com.site.joblisting.dao;

import com.site.joblisting.entities.Job;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobDao {

    List<Job> getAllPostedJobs();

    Page<Job> getAllPostedJobsWithPagination(int offset);

    Job getJob(int id);

    void insertJob(Job job);

    void updateJob(int id, Job job);

    void deleteJob(int id);

    void applyJob(int userId, int jobId);

    void unApplyJob(int userId, int jobId);

    Page<Job> searchJobs(String query, int offset);
}
