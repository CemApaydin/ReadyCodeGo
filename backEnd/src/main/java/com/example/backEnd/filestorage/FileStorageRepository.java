package com.example.backEnd.filestorage;

import com.example.backEnd.facultyboardmember.FacultyBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {
}
