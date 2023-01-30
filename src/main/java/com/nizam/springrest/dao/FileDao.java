package com.nizam.springrest.dao;

import com.nizam.springrest.entities.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDao extends JpaRepository<FileData,Long> {
}
