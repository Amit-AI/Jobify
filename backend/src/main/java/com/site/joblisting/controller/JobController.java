package com.site.joblisting.controller;

import com.site.joblisting.dao.JobDao;
import com.site.joblisting.dao.UserDao;
import com.site.joblisting.entities.Jobs;
import com.site.joblisting.entities.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobDao jobDao;

    @Autowired
    UserDao userDao;

    @GetMapping
    public ResponseEntity<List<Jobs>> getAllJobs() {
        return new ResponseEntity<>(jobDao.getAllPostedJobs(), HttpStatus.OK);
    }

    @GetMapping(params = {"pageNumber"})
    public ResponseEntity<Page<Jobs>> getAllJobsWithPagination(@RequestParam int pageNumber) {
        return new ResponseEntity<>(jobDao.getAllPostedJobsWithPagination(pageNumber), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jobs> getJob(@PathVariable int id) {
        return new ResponseEntity<>(jobDao.getJob(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Jobs job) {
        jobDao.insertJob(job);
        return new ResponseEntity<>("Job inserted successfully!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Jobs job) {
        jobDao.updateJob(id, job);
        return new ResponseEntity<>("Job updated successfully!!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        jobDao.deleteJob(id);
        return new ResponseEntity<>("Job deleted successfully!!", HttpStatus.OK);
    }

    @PostMapping("/{userId}/{jobId}")
    public ResponseEntity<String> applyJob(@PathVariable int userId, @PathVariable int jobId, Principal p) {
        jobDao.applyJob(userId, jobId);
        return new ResponseEntity<>("Job applied successfully!!", HttpStatus.CREATED);
    }

    @PutMapping("/unapply/{jobId}")
    public ResponseEntity<String> unApplyJob(@PathVariable int jobId, Principal loggedInUser) {
        Users userDetails = userDao.findByUserEmail(loggedInUser.getName());

        jobDao.unApplyJob(userDetails.getUserId(), jobId);

        return ResponseEntity.ok("UnApplied from Job with ID: " + jobId);

    }

    // TODO: fix this searchJob API
    @GetMapping("/search")
    public ResponseEntity<Page<Jobs>> searchJobs(@RequestParam("query") String query, @RequestParam("pageNumber") int pageNumber) {

        return new ResponseEntity<>(jobDao.searchJobs(query, pageNumber), HttpStatus.OK);

    }
}
