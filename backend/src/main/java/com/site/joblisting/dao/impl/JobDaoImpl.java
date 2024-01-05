package com.site.joblisting.dao.impl;

import com.site.joblisting.dao.JobDao;
import com.site.joblisting.entities.Job;
import com.site.joblisting.entities.UserJob;
import com.site.joblisting.exceptions.NotFoundException;
import com.site.joblisting.repositories.JobRepository;
import com.site.joblisting.repositories.UserJobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class JobDaoImpl implements JobDao {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserJobRepository userJobRepository;

    private static final int jobsPerPage = 2;


    @Override
    public List<Job> getAllPostedJobs() {

        return jobRepository.findAll();
    }

    @Override
    public Page<Job> getAllPostedJobsWithPagination(int pageNumber) {
        return jobRepository.findAll(PageRequest.of(pageNumber, jobsPerPage));
    }

    @Override
    public Job getJob(int id) {

        return jobRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Job not found with ID: "+id));
    }

    @Override
    public void insertJob(Job job) {

        jobRepository.save(job);

    }

    @Override
    public void updateJob(int id, Job job) {

        Job tempJob = jobRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Job not found with ID: "+id));

        tempJob.setJobRole(job.getJobRole());
        tempJob.setCompanyName(job.getCompanyName());
        tempJob.setJobDescription(job.getJobDescription());
        tempJob.setJobPostExpires(job.getJobPostExpires());
        tempJob.setJobExperienceRequired(job.getJobExperienceRequired());
        tempJob.setJobLocation(job.getJobLocation());

        jobRepository.save(tempJob);

    }

    @Override
    public void deleteJob(int id) {
        try {
            jobRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("User Not Found With ID: " + id);
        }

        userJobRepository.deleteUserAppliedJob(id);
    }

    @Override
    public void applyJob(int userId, int jobId) {
        UserJob userJob = new UserJob();
        userJob.setUserId(userId);
        userJob.setJobId(jobId);

        userJobRepository.save(userJob);

    }

    @Override
    public void unApplyJob(int userId, int jobId) {
        List<Integer> allJobIdByUserId = userJobRepository.findAllJobIdByUserId(userId);

        if (allJobIdByUserId.isEmpty()) {
            throw new NotFoundException("No Jobs applied by User with ID: " + userId);
        }

        allJobIdByUserId.stream()
                .filter(id -> id == jobId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User haven't applied to Job with ID: " + jobId));

        userJobRepository.unapplyJobForUser(userId, jobId);
    }

    @Override
    public Page<Job> searchJobs(String query, int pageNumber) {
        return jobRepository.searchJobs(query, PageRequest.of(pageNumber, jobsPerPage));
    }
}
