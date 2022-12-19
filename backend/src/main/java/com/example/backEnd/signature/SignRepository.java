package com.example.backEnd.signature;
import com.example.backEnd.filestorage.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SignRepository extends JpaRepository<Sign, Long> {
}