package com.site.joblisting.dto;

import com.site.joblisting.entities.Jobs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJobDTO {

    private String userName;
    private List<Jobs> jobs;
}
