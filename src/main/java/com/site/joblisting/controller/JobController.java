package com.site.joblisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.site.joblisting.dao.JobDao;
import com.site.joblisting.entities.Job;

@RestController
@CrossOrigin
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobDao jobDao;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobDao.getAllPostedJobs(), HttpStatus.OK);
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
    public ResponseEntity<String> applyJob(@PathVariable int userId, @PathVariable int jobId) {
        jobDao.applyJob(userId, jobId);
        return new ResponseEntity<>("Job applied successfully!!", HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam("query") String query) {

        return new ResponseEntity<>(jobDao.searchJobs(query), HttpStatus.OK);

    }
}
