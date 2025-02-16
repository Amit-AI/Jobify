package com.site.joblisting.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Column(insertable = false)
    private String updatedBy;


    @PrePersist
    protected void onCreate() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        this.createdAt = LocalDateTime.now();
        this.createdBy = auth != null ? auth.getName() : null;
    }

    @PreUpdate
    protected void onUpdate() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = auth.getName();
    }
}
