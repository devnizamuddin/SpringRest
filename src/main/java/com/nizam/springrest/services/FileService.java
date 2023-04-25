package com.nizam.springrest.services;

import com.nizam.springrest.dao.FileDao;
import com.nizam.springrest.dao.StorageDao;
import com.nizam.springrest.entities.FileData;
import com.nizam.springrest.entities.ImageData;
import com.nizam.springrest.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileService {

    private final String FOLDER_PATH = "/Users/nizamuddinshamrat/Desktop/SpringRestFile/";
    //private final String FOLDER_PATH = "/Users/md.nizamuddinshamrat/Desktop/Image/";
    @Autowired
    FileDao fileDao;
    @Autowired
    StorageDao storageDao;

    public String uploadFileInServer(MultipartFile file) throws IOException {

        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData = fileDao.save(FileData.builder()
                .name(file.getOriginalFilename()).type(file.getContentType())
                .location(filePath).build());

        if (fileData != null) {

            file.transferTo(new File(filePath));
            return "File Upload Successfully";
        } else {
            return "Error";
        }
    }

    public byte[] getFileFromServer(String fileName) throws IOException {

        Optional<FileData> fileData = fileDao.findByName(fileName);
        String filePath = fileData.get().getLocation();
        byte[] imageData = Files.readAllBytes(new File(filePath).toPath());

        return imageData;
    }

    public String uploadFileInDatabase(MultipartFile file) throws IOException {
        ImageData imageData = storageDao.save(ImageData.builder().name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "File uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] getFileFromDatabase(String fileName) {
        Optional<ImageData> dbImageData = storageDao.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
