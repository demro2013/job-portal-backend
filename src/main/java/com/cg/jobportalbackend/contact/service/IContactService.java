package com.cg.jobportalbackend.contact.service;

import com.cg.jobportalbackend.dto.ContactDTO;

public interface IContactService {
    boolean saveContact(ContactDTO contactDTO);
}
