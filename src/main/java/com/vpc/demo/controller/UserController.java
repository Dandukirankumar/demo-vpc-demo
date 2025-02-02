package com.vpc.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vpc.demo.service.UserInterface;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    @Autowired
    private UserInterface userService;

    @GetMapping("getUserDetails")
    public ResponseEntity<List<Map<String,Object>>> getUserDetails() {
        List<Map<String,Object>> userDetails = userService.getUserDetails();
       return ResponseEntity.ok().body(userDetails);
    }

    @PostMapping("addUserDetails")
    public ResponseEntity<Map<String,Object>>  postUserDetials(@RequestBody Map<String, Object> userDetials) {
        Map<String,Object> user= userService.addUserDetails(userDetials);
        return ResponseEntity.ok().body(user);

    }
}
