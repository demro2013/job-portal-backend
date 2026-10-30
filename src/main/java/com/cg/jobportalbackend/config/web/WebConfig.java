package com.cg.jobportalbackend.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.useMediaTypeParameter(MediaType.parseMediaType("application/vnd.jobapp+json"),"v")
                .addSupportedVersions("1.0","2.0","3.0").setDefaultVersion("1.0");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api", _ -> true);
        //_ -> true <--used to determine with controllers the prefix should be attached to, we want it on all of them which is why you see this expression
    }   //_ -> true <--always returns true and the _ means its an unnamed variable, which is so IDE doesn't give us a warning about it not being used anywhere

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
