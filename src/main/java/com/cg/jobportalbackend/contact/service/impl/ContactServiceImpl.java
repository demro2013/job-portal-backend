package com.cg.jobportalbackend.contact.service.impl;

import com.cg.jobportalbackend.contact.service.IContactService;
import com.cg.jobportalbackend.dto.ContactDTO;
import com.cg.jobportalbackend.entity.Contact;
import com.cg.jobportalbackend.contact.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactDTO contactDTO) {
        boolean result = false;
        Contact savedContact = contactRepository.save(mapToEntity(contactDTO));
        if (savedContact != null && savedContact.getId() != null) {
            result = true;
        }
        return result;
    }

    private List<ContactDTO> mapToDTO(List<Contact> contacts) {
        return contacts.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private ContactDTO mapToDTO(Contact contact) {
        if (contact == null) {
            return null;
        }
        return new ContactDTO(
                contact.getEmail(),
                contact.getMessage(),
                contact.getName(),
                contact.getSubject(),
                contact.getUserType()
        );
    }

    private Contact mapToEntity(ContactDTO dto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(dto, contact);
        contact.setCreatedAt(Instant.now());
        contact.setCreatedBy("System");
        contact.setStatus("NEW");
        return contact;
    }
}
