package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Welcome to Anudip Foundation");
    }
    @GetMapping("/services")
    public String sayService(){
        return "Software Development";
    }
    @GetMapping("/user")
    public Principal getuserDetails(Principal principal){
        return principal;
    }



}
