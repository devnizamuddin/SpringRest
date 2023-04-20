package com.nizam.springrest.services;

import com.nizam.springrest.dao.FileDao;
import com.nizam.springrest.entities.FileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private final String FOLDER_PATH = "/Users/nizamuddinshamrat/Desktop/SpringRestFile/";
    //private final String FOLDER_PATH = "/Users/md.nizamuddinshamrat/Desktop/Image/";
    @Autowired
    FileDao fileDao;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData = fileDao.save(FileData.builder()
                .name(file.getOriginalFilename()).type(file.getContentType())
                .location(filePath).build());

        if (fileData!=null){

            file.transferTo(new File(filePath));
            return "File Upload Successfully";
        }
        else {
            return "Error";
        }
    }

    @Override
    public byte[] downloadFile(String fileName) throws IOException {

       Optional<FileData> fileData =  fileDao.findByName(fileName);
       String filePath = fileData.get().getLocation();
       byte[] imageData = Files.readAllBytes(new File(filePath).toPath());

        return imageData;
    }
}
