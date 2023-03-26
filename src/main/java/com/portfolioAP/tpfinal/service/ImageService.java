package com.portfolioAP.tpfinal.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.portfolioAP.tpfinal.dto.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {
    @Autowired
    private Environment environment;

    public ImageDTO upload(MultipartFile multipartFile) throws IOException {
        Path actualPath = Paths.get("");
        String sp = actualPath.toAbsolutePath().toString();

        String bucketName = environment.getProperty("firebase.bucket.name");
        String projectId = environment.getProperty("firebase.project.id");
        FileInputStream serviceAccount = new FileInputStream(sp + environment.getProperty("firebase.credentials"));
        StorageOptions storageOptions = StorageOptions.newBuilder()
                .setProjectId(projectId)
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        //guardamos un identificador unico al azar y lo pasamos a string
        String uuid = UUID.randomUUID().toString();

        //esto es de google storage
        Storage storage = storageOptions.getService();
        //A BlobId object includes the name of the containing bucket, the blob's name and possibly the blob's generation.

        //BlobId.of(String bucket, String name)
        BlobId blobId = BlobId.of(bucketName, uuid);

        //A BlobInfo object includes the BlobId instance and the set of properties
        //BlobInfo blobInf = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(multipartFile.getContentType()).build();

        byte[] arrayByte;
        arrayByte=multipartFile.getBytes();
        // A Blob object includes the BlobId instance, the set of properties inherited from the BlobInfo class and the Storage instance.
        // Blob blob = storage.create(blobInfo, "Hello, world".getBytes(StandardCharsets.UTF_8));


        Blob blob = storage.create(blobInfo, arrayByte);

        ImageDTO dto = new ImageDTO(uuid);

        return dto;
    }

}
