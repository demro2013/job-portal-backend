package com.cg.jobportalbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.cg.jobportalbackend.entity.Contact}
 */
public record ContactDTO(
        @NotBlank(message = "Name must not be blank")
        @Size(min = 3, max = 50, message = "Name must be within length constraints")
        String name,
        @Email(message = "Email must be proper format")
        @NotBlank(message = "Email cannot be blank")
        String email,
        @NotBlank(message = "Message must not be blank")
        @Size(min = 10, max = 250, message = "Message must be within length constraints")
        String message,
        @NotBlank(message = "Subject must not be blank")
        String subject,
        @Pattern(regexp = "Job Seeker|Employer|Other", message = "Selection must be Job Seeker|Employer|Other")
        String userType
) implements Serializable {







}