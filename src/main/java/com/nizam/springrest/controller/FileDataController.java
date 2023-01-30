package com.nizam.springrest.controller;

import com.nizam.springrest.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("/file")
public class FileDataController {

    @Autowired
    FileService fileService;


    @PostMapping()
    String fileUpload(@RequestParam MultipartFile file) throws IOException {
       return fileService.uploadFile(file);
    }

}
