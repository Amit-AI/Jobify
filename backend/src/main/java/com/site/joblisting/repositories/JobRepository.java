package com.site.joblisting.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.site.joblisting.entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
    
    @Query(value="SELECT j FROM Job j WHERE " +
    "j.companyName LIKE CONCAT('%',:query, '%')" +
    "Or j.jobDescription LIKE CONCAT('%', :query, '%')" +
    "Or j.jobRole LIKE CONCAT('%', :query, '%')" +
    "Or j.jobLocation LIKE CONCAT('%', :query, '%')")
    Page<Job> searchJobs(String query, Pageable pageable);
}
