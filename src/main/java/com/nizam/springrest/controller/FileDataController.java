package com.nizam.springrest.controller;

import com.nizam.springrest.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileDataController {

    @Autowired
    FileService fileService;

    @PostMapping(value = "/server")
    public ResponseEntity<?> uploadFileInServer(@RequestParam("file") MultipartFile file) throws IOException {

        String uploadImage = fileService.uploadFileInServer(file);

        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/server/{fileName}")
    public ResponseEntity<?> getFileFromServer(@PathVariable String fileName) throws IOException {

        byte[] imageData = fileService.getFileFromServer(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageData);
    }

    @PostMapping("/database")
    public ResponseEntity<?> uploadFileInDatabase(@RequestParam("file") MultipartFile file) throws IOException {

        String uploadImage = fileService.uploadFileInDatabase(file);

        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/database/{fileName}")
    public ResponseEntity<?> getFileFromDatabase(@PathVariable String fileName) {

        byte[] imageData = fileService.getFileFromDatabase(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png")).body(imageData);
    }

}
