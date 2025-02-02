package com.vpc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vpc.demo.service.StorageInterface;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageInterface storageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        String message = storageService.uploadFile(file);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadFile(@RequestParam("file") String file) {
        String message = storageService.downloadFile(file);
        return ResponseEntity.ok(message);
    }

    
}
