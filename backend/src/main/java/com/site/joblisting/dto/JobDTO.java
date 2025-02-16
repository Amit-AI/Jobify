package com.site.joblisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {

    private String companyName;
    private String jobRole;
    private String jobLocation;
    private String jobDescription;
    private String jobPosted;
    private String jobPostExpires; // date
    private String jobExperienceRequired;
}
