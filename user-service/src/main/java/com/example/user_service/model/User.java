package com.example.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String phone;
    private List<Contact> contacts=new ArrayList<>();

    public User(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
