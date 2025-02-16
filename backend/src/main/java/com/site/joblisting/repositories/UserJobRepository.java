package com.site.joblisting.repositories;

import com.site.joblisting.entities.UserJob;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
    void deleteUserAppliedJob(int jobId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserJob u WHERE u.userId=?1 AND u.jobId=?2")
    void unapplyJobForUser(int userId, int jobId);
}
