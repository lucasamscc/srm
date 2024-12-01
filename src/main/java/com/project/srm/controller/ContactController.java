package com.project.srm.controller;

import com.project.srm.dto.ContactRequestDTO;
import com.project.srm.model.Company;
import com.project.srm.model.Contact;
import com.project.srm.model.response.SuccessResponse;
import com.project.srm.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{cdCompany}/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getContacts(@PathVariable String cdCompany) {
        return contactService.getContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id, @PathVariable String cdCompany) {
        Contact byId = contactService.getContact(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@PathVariable Long cdCompany, @RequestBody @Valid ContactRequestDTO contactRequestDTO) {
        Contact savedContact = contactService.saveContact(contactRequestDTO, cdCompany);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        SuccessResponse response = new SuccessResponse("Contato excluído com sucesso!");
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Void> updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        contactService.updateContact(contact, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
