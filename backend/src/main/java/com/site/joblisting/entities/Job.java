package com.site.joblisting.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String jobRole;

    @Lob
    @Column(nullable = false)
    private String jobLocation;

    @Lob
    @Column(nullable = false)
    private String jobDescription;

    @Column(nullable = false)
    private final String jobPosted = setJobPosted();

    @Column(nullable = false)
    private String jobPostExpires; // date

    @Column(nullable = false)
    private String jobExperienceRequired;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobPosted() {
        return jobPosted;
    }

    public String setJobPosted() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    }

    public String getJobPostExpires() {
        return jobPostExpires;
    }

    public void setJobPostExpires(String jobPostExpires) {
        this.jobPostExpires = jobPostExpires;
    }

    public String getJobExperienceRequired() {
        return jobExperienceRequired;
    }

    public void setJobExperienceRequired(String jobExperienceRequired) {
        this.jobExperienceRequired = jobExperienceRequired;
    }

    @Override
    public String toString() {
        return "Job [jobId=" + jobId + ", companyName=" + companyName + ", jobRole=" + jobRole + ", jobLocation="
                + jobLocation + ", jobDescription=" + jobDescription + ", jobPosted=" + jobPosted + ", jobPostExpires="
                + jobPostExpires + "]";
    }

}
