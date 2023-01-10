package com.site.joblisting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.site.joblisting.entities.Job;
import com.site.joblisting.repositories.JobRepository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JobDaoImpl_springDataJPA implements JobDao {

    @Autowired
    JobRepository jobRepository;

    @Override
    public void deleteJob(int id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> getAllPostedJobs() {

        return jobRepository.findAll();
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

}
