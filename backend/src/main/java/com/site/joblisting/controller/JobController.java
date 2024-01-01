package com.site.joblisting.controller;

import com.site.joblisting.dao.JobDao;
import com.site.joblisting.dao.UserDao;
import com.site.joblisting.entities.Job;
import com.site.joblisting.entities.User;
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
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobDao.getAllPostedJobs(), HttpStatus.OK);
    }

    @GetMapping(params = {"pageNumber"})
    public ResponseEntity<Page<Job>> getAllJobsWithPagination(@RequestParam int pageNumber) {
        return new ResponseEntity<>(jobDao.getAllPostedJobsWithPagination(pageNumber), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable int id) {
        return new ResponseEntity<>(jobDao.getJob(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Job job) {
        jobDao.insertJob(job);
        return new ResponseEntity<>("Job inserted successfully!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Job job) {
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
        log.info(p.getName());
        jobDao.applyJob(userId, jobId);
        return new ResponseEntity<>("Job applied successfully!!", HttpStatus.CREATED);
    }

    @PutMapping("/unapply/{jobId}")
    public ResponseEntity<String> unApplyJob(@PathVariable int jobId, Principal principal) {
        User userDetails = userDao.findByUserEmail(principal.getName());

        jobDao.unApplyJob(userDetails.getUserId(), jobId);

        return ResponseEntity.ok("UnApplied from Job with ID: " + jobId);

    }

    // TODO: fix this searchJob API
    @GetMapping("/search")
    public ResponseEntity<Page<Job>> searchJobs(@RequestParam("query") String query, @RequestParam("pageNumber") int pageNumber) {

        return new ResponseEntity<>(jobDao.searchJobs(query, pageNumber), HttpStatus.OK);

    }
}
