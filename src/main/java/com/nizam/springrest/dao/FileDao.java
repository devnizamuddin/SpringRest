package com.nizam.springrest.dao;

import com.nizam.springrest.entities.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDao extends JpaRepository<FileData,Long> {
    Optional<FileData>findByName(String name);
}
