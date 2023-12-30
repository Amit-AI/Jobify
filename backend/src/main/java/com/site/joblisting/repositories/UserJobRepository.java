package com.site.joblisting.repositories;

import com.site.joblisting.entities.UserJob;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserJobRepository extends JpaRepository<UserJob, Integer> {

    @Query("Select jobId from UserJob u where u.userId=?1")
    List<Integer> findAllJobIdByUserId(int userId);

    @Transactional
    @Modifying
    @Query("Delete from UserJob u where u.userId=?1")
    void deleteJobWhenUserDeleted(int userId);

    @Transactional
    @Modifying
    @Query("Delete from UserJob u where u.jobId=?1")
    void deleteUserWhenJobDeleted(int jobId);
}
