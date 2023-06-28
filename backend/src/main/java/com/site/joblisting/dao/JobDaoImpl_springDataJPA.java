package com.site.joblisting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.site.joblisting.entities.Job;
import com.site.joblisting.entities.UserJob;
import com.site.joblisting.exceptions.NotFoundException;
import com.site.joblisting.repositories.JobRepository;
import com.site.joblisting.repositories.UserJobRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JobDaoImpl_springDataJPA implements JobDao {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserJobRepository userJobRepository;

    private static final int pageSize = 2;

    @Override
    public void deleteJob(int id) {
        try {
            jobRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("User Not Found With ID: " + id);
        }

        userJobRepository.deleteUserWhenJobDeleted(id);
    }

    @Override
    public List<Job> getAllPostedJobs() {

        return jobRepository.findAll();
    }

    @Override
    public Page<Job> getAllPostedJobsWithPagination(int offset) {
        return jobRepository.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Job getJob(int id) {

        return jobRepository.findById(id).get();
    }

    @Override
    public void insertJob(Job job) {

        jobRepository.save(job);

    }

    @Override
    public void updateJob(int id, Job job) {

        Job tempJob = jobRepository.findById(id).get();

        tempJob.setJobRole(job.getJobRole());
        tempJob.setCompanyName(job.getCompanyName());
        tempJob.setJobDescription(job.getJobDescription());
        tempJob.setJobPostExpires(job.getJobPostExpires());
        tempJob.setJobExperienceRequired(job.getJobExperienceRequired());
        tempJob.setJobLocation(job.getJobLocation());

        jobRepository.save(tempJob);

    }

    @Override
    public void applyJob(int userId, int jobId) {
        UserJob userJob = new UserJob();
        userJob.setUserId(userId);
        userJob.setJobId(jobId);

        userJobRepository.save(userJob);

    }

    @Override
    public Page<Job> searchJobs(String query, int offset) {
        return jobRepository.searchJobs(query, PageRequest.of(offset, pageSize));
    }
}
