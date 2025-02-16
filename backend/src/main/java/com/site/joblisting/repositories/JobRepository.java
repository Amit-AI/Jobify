package com.site.joblisting.repositories;

import com.site.joblisting.entities.Jobs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Integer> {

    @Query(value = "SELECT j FROM Job j WHERE " +
            "j.companyName LIKE CONCAT('%',:query, '%')" +
            "Or j.jobDescription LIKE CONCAT('%', :query, '%')" +
            "Or j.jobRole LIKE CONCAT('%', :query, '%')" +
            "Or j.jobLocation LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    Page<Jobs> searchJobs(String query, Pageable pageable);
}
