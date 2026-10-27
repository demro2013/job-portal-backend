package com.cg.jobportalbackend.contact.repository;

import com.cg.jobportalbackend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}