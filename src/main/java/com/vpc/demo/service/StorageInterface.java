package com.vpc.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface StorageInterface {
    public String uploadFile(MultipartFile file);
    public String downloadFile(String file);
}
