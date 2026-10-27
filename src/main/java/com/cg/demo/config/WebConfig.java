package com.cg.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.useMediaTypeParameter(MediaType.parseMediaType("application/vnd.cg+json"),"v")
                .addSupportedVersions("1.0","2.0","3.0")
                .setDefaultVersion("1.0");
            //pass an accept header with value: application/vnd.cg+json;v=2.0 or v=1.0
        //configurer.useRequestHeader("X-API-VERSION").addSupportedVersions("1.0","2.0","3.0").setDefaultVersion("1.0");
            //pass X-API-VERSION as a header with value of 1.0 or 2.0 in request
        //configurer.useQueryParam("version").addSupportedVersions("1.0","2.0","3.0").setDefaultVersion("1.0");
            //pass query param in URL: api/versions?version=1.0
        //configurer.usePathSegment(2).addSupportedVersions("1.0","2.0","3.0").setDefaultVersion("1.0");
            //index: 2 means in the versioncontroller mapping url: /api/version/{v}
    }                                                            //  0     1     2 <--what we are targeting
}
