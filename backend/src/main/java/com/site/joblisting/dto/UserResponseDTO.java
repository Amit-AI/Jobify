package com.site.joblisting.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {

    Integer id;
    String name;
    String email;
    String role;
}
