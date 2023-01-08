package com.site.joblisting.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    private String companyName;
    private String jobRole;

    @Lob
    private String jobLocation;

    @Lob
    private String jobDescription;

    private String jobPosted; // date
    private String jobPostExpires; // date

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

    public void setJobPosted(String jobPosted) {
        this.jobPosted = jobPosted;
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
