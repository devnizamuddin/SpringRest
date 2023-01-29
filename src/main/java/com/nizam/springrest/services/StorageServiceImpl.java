package com.nizam.springrest.services;

import com.nizam.springrest.dao.StorageDao;
import com.nizam.springrest.entities.ImageData;
import com.nizam.springrest.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageServiceImpl implements  StorageService{

    @Autowired
    StorageDao storageDao;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
       ImageData imageData =  storageDao.save(ImageData.builder().name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
       if (imageData!=null){
           return "File uploaded successfully : "+file.getOriginalFilename();
       }
        return null;
    }

    @Override
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = storageDao.findByName(fileName);
        byte[]images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
