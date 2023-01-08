package com.site.joblisting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.joblisting.entities.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{
    
}
