package com.site.joblisting.dao;

import com.site.joblisting.entities.Jobs;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobDao {

    List<Jobs> getAllPostedJobs();

    Page<Jobs> getAllPostedJobsWithPagination(int offset);

    Jobs getJob(int id);

    void insertJob(Jobs job);

    void updateJob(int id, Jobs job);

    void deleteJob(int id);

    void applyJob(int userId, int jobId);

    void unApplyJob(int userId, int jobId);

    Page<Jobs> searchJobs(String query, int offset);
}
