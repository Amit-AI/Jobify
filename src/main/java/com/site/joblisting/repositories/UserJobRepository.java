package com.site.joblisting.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.site.joblisting.entities.UserJob;

import jakarta.transaction.Transactional;

public interface UserJobRepository extends JpaRepository<UserJob, Integer>{

    @Query("Select jobId from UserJob u where u.userId=?1")
    public List<Integer> findAllJobIdByUserId(int userId);
    
    @Transactional
    @Modifying
    @Query("Delete from UserJob u where u.userId=?1")
    public void deleteJobWhenUserDeleted(int userId);

    @Transactional
    @Modifying
    @Query("Delete from UserJob u where u.jobId=?1")
    public void deleteUserWhenJobDeleted(int jobId);
}
