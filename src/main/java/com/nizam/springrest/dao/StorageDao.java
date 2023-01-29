package com.nizam.springrest.dao;

import com.nizam.springrest.entities.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  StorageDao extends JpaRepository<ImageData,Long> {

    Optional<ImageData>findByName(String fileName);

    byte[] downloadImage(String fileName);
}
