package com.site.joblisting.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private final String jobPosted = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());

    @Column(nullable = false)
    private String jobPostExpires; // date

    @Column(nullable = false)
    private String jobExperienceRequired;
}
