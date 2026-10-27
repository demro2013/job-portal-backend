package com.cg.jobportalbackend.contact.controller;

import com.cg.jobportalbackend.contact.service.IContactService;
import com.cg.jobportalbackend.dto.ContactDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {

    private final IContactService service;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody ContactDTO contactDTO) {
        boolean result = service.saveContact(contactDTO);
        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
    }
}
