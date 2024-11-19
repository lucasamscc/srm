package com.project.srm.service;

import com.project.srm.model.Contact;
import com.project.srm.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElseThrow();
    }

    public List<Contact> getCompanies() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Contact saveCompany(Contact contact) {

        return contactRepository.save(contact);
    }

    public void deleteCompany(Long id) {
        contactRepository.deleteById(id);
    }

    public void updateCompany(Contact contact, Long id) {
        Contact exist = contactRepository.findById(id).orElseThrow();
        exist.setNmContact(contact.getNmContact());
        exist.setEmail(contact.getEmail());
        exist.setPhone(contact.getPhone());
        exist.setRole(contact.getRole());
        exist.setDescription(contact.getDescription());
        contactRepository.save(exist);
    }
}
