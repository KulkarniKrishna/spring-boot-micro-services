package com.example.contact_service.controller;


import com.example.contact_service.model.Contact;
import com.example.contact_service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.SequencedCollection;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/byUserId/{userid}")
    public List<Contact> getContactsByUserId(@PathVariable Long userid){
        return contactService.getContactOfUserById(userid);
    }

}
