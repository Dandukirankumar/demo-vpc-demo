package com.vpc.demo.service;


import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class UserService implements UserInterface{

    List<Map<String,Object>> userDetials = new ArrayList<>();

    @Override
    public List<Map<String,Object>> getUserDetails() {
        return userDetials;
    }

    @Override
    public Map<String, Object> addUserDetails(Map<String, Object> userDetial) {
        userDetials.add(userDetial);
        return userDetial;
    }
}
