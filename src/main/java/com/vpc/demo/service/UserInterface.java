package com.vpc.demo.service;

import com.vpc.demo.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserInterface {
    public List<Map<String,Object>> getUserDetails();

    Map<String, Object> addUserDetails(Map<String, Object> userDetails);
}
