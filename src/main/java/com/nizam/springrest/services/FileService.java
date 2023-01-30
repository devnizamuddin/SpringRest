package com.nizam.springrest.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
     String uploadFile(MultipartFile file) throws IOException;
     byte[] downloadFile(String fileName);
}
