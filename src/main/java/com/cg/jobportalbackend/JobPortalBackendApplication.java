package com.cg.jobportalbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@SpringBootApplication
public class JobPortalBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobPortalBackendApplication.class, args);
    }
}
