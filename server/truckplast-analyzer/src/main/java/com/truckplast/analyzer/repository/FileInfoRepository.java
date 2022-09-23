package com.truckplast.analyzer.repository;

import com.truckplast.analyzer.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileInfoRepository extends JpaRepository<FileInfo, UUID> {

}
