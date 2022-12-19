package com.example.backEnd.filestorage;

import com.example.backEnd.facultyboardmember.FacultyBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository

public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
    @Query("SELECT s FROM FileStorage s  WHERE s.documentID = ?1")
    public FileStorage findFromDocumentID(long documentID);
}
