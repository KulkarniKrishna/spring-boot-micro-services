package com.example.user_service.controller;


import com.example.user_service.model.User;
import com.example.user_service.serivce.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @CircuitBreaker(name = "userservice",fallbackMethod = "UserServiceFallback")
    @TimeLimiter(name = "userservice") //returns CompletableFuture
    @Retry(name = "userservice")
    public CompletableFuture<ResponseEntity<User>> getUser(@PathVariable Long id){
        return CompletableFuture.supplyAsync(()->new ResponseEntity<>(userService.getUserDetails(id), HttpStatus.OK));
    }

    // fallback for above api endpoint
    public CompletableFuture<ResponseEntity<User>> UserServiceFallback(Long id, RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()->new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
