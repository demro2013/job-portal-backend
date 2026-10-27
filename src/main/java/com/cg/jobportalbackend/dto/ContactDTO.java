package com.cg.jobportalbackend.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.cg.jobportalbackend.entity.Contact}
 */
public record ContactDTO(String email, String message, String name, String subject,
                         String userType) implements Serializable {







}