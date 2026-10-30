package com.cg.jobportalbackend.contact.controller;

import com.cg.jobportalbackend.contact.service.IContactService;
import com.cg.jobportalbackend.dto.ContactDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {

    private final IContactService service;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody @Valid ContactDTO contactDTO) {
        boolean result = service.saveContact(contactDTO);
        if (result) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request");
    }

    @GetMapping(version = "1.0")
    public ResponseEntity<String> fetchOpenContacts(@Validated @RequestParam
                                                        @Size(min = 3, max = 25, message = "Status must be within size constraints")
                                                        @NotBlank(message = "Status cannot be blank") String status) {

        return ResponseEntity.ok("These are the contacts with the given status: " + status);
        //List<ContactDTO> contacts = service.getOpenStatusContacts(status);
    }
}
