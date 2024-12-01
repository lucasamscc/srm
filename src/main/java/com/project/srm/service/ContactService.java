package com.project.srm.service;

import com.project.srm.dto.ContactRequestDTO;
import com.project.srm.exception.ResourceNotFoundException;
import com.project.srm.model.Company;
import com.project.srm.model.Contact;
import com.project.srm.model.Supplier;
import com.project.srm.model.SupplierCategory;
import com.project.srm.model.response.SuccessResponse;
import com.project.srm.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CompanyService companyService;

    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Contato com não encontrado"));
    }

    public List<Contact> getContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Contact saveContact(ContactRequestDTO contactRequestDTO, Long cdCompany) {
        Contact contact = new Contact();
        contact.setNmContact(contactRequestDTO.getNmContact());
        contact.setRole(contactRequestDTO.getRole());
        contact.setPhone(contactRequestDTO.getPhone());
        contact.setEmail(contactRequestDTO.getEmail());
        contact.setDescription(contactRequestDTO.getDescription());

        Company company = companyService.getCompany(cdCompany);
        contact.setCompany(company);

        return contactRepository.save(contact);
    }

    public void updateContact(Contact contact, Long id) {
        Contact exist = contactRepository.findById(id).orElseThrow();
        exist.setNmContact(contact.getNmContact());
        exist.setEmail(contact.getEmail());
        exist.setPhone(contact.getPhone());
        exist.setRole(contact.getRole());
        exist.setDescription(contact.getDescription());
        contactRepository.save(exist);
    }

    public void deleteContact(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado"));
        contactRepository.delete(contact);
    }
}
