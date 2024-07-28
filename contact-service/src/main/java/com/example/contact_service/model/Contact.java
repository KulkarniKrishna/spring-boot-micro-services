package com.example.contact_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Long cid;
    private String email;
    private String name;
    private Long userId;
}