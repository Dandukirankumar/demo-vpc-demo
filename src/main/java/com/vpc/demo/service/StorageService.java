package com.vpc.demo.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.vpc.demo.config.SecretManager;
@Component
public class StorageService implements StorageInterface {

    @Autowired
    private SecretManager secretManager;
//    private static final String BUCKET_NAME = "my-unique-bucket-app-448806"; // Replace with your actual bucket name
    // @Value("${spring.cloud.gcp.secretmanager.project-id}")
    // private String projectId;
    // @Value("${sm://projects/my-fullstack-app-448806/secrets/my-bucket-name/versions/latest}")
//     private String secretName;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
           String secretName = secretManager.accessSecret();
            String fileName = file.getOriginalFilename();
            BlobId blobId = BlobId.of(secretName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                    .setContentType(file.getContentType())
                    .build();

            Storage storage = StorageOptions.getDefaultInstance().getService();

            storage.create(blobInfo, file.getBytes());

            return "File uploaded successfully: " + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    @Override
    public String downloadFile(String fileName) {
        try {
       	String secretName = secretManager.accessSecret();
            BlobId blobId = BlobId.of(secretName, fileName);
//            Storage storage =
//                StorageOptions.getDefaultInstance().getService();
            GoogleCredentials credentials = GoogleCredentials.fromStream(
                    new FileInputStream("/Users/da20422734/LOCAL-STORAGE-CLIENT-KEY.json")
                );

                // Initialize the Storage client
                Storage storage = StorageOptions.newBuilder()
                    .setCredentials(credentials)
                    .build()
                    .getService();

            Blob blob = storage.get(blobId);
            if (blob == null) {
                throw new RuntimeException("File not found: " + fileName);
            }

            // Generate a signed URL that's valid for 15 minutes
            URL signedUrl = blob.signUrl(15, TimeUnit.MINUTES);
            return signedUrl.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to download file", e);
        }
    }
}
