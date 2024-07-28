package com.example.user_service.serivce;

import com.example.user_service.model.Contact;
import com.example.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class UserServiceImp implements UserService{


    @Autowired
    private RestTemplate restTemplate;

    List<User> users=List.of(
            new User(1311L,"Krishna","1234123412"),
            new User(1312L,"Sydney","1234123412"),
            new User(1313L,"Robert","1234123412")
    );

    @Override
    public User getUserDetails(Long id) {
        User userRes=users.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);

        // calling another service synchronously
        List contacts=restTemplate.getForObject("http://contact-service/contact/byUserId/"+id,List.class);
        userRes.setContacts(contacts);
        return userRes;
    }
}
