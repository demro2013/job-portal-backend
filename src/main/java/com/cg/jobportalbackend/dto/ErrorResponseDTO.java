package com.cg.jobportalbackend.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDTO(String apiPath,
                               String errorMessage,
                               HttpStatus httpStatus,
                               LocalDateTime errorTime) {
}
