package com.tp.notification.repository;

import com.tp.notification.entity.FileInf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfRepository extends JpaRepository<FileInf, Long> {

    FileInf findByRealFileName(String realFileName);
}
