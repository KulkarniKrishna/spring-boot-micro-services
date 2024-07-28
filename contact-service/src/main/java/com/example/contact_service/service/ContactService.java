package com.example.contact_service.service;

import com.example.contact_service.model.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getContactOfUserById(Long userid);
}
