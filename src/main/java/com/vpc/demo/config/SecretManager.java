package com.vpc.demo.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretManagerServiceSettings;
import com.google.cloud.secretmanager.v1.SecretVersionName;

@Component
public class SecretManager {
    // Read from environment variables
    String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
    String secretName = System.getenv("MY_SECRET_NAME");

    public String accessSecret() {
        String secretValue = "";
        try {

            SecretManagerServiceClient client = SecretManagerServiceClient.create(
                SecretManagerServiceSettings.newBuilder().build()
            );

            // Access secret
            SecretVersionName secretVersion = SecretVersionName.of(projectId, secretName, "latest");
            AccessSecretVersionResponse response = client.accessSecretVersion(secretVersion);
            secretValue = response.getPayload().getData().toStringUtf8();
            System.out.println("Secret Value: " + secretValue);
        } catch (IOException e) {
            System.err.println("Failed to create client: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return secretValue;
    }
}
