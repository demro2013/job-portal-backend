package com.cg.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/versions/{v}") used in conjuction with path variable versioning system
@RequestMapping("/api/versions")
public class VersionController {

    @GetMapping(version = "1.0")
    public ResponseEntity<String> version1Endpoint(){
        return ResponseEntity.ok("version 1.0");
    }

    @GetMapping(version = "2.0")
    public ResponseEntity<String> version2Endpoint(){
        return ResponseEntity.ok("version 2.0");
    }
}
