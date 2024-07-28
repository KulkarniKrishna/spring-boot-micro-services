package com.example.contact_service.service;

import com.example.contact_service.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImp implements ContactService{

    List<Contact> contacts=List.of(
            new Contact(1L,"Ross@test.com","Ross",1313L),
            new Contact(2L,"Rachel@test.com","Rachel",1313L),
            new Contact(3L,"Joe@test.com","Joe",1311L)
    );

    @Override
    public List<Contact> getContactOfUserById(Long userid) {
        return contacts.stream().filter(contact -> contact.getUserId().equals(userid)).collect(Collectors.toList());
    }
}
