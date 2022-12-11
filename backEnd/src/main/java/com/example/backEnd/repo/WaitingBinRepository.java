package com.example.backEnd.repo;
import com.example.backEnd.entity.WaitingBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingBinRepository extends JpaRepository<WaitingBin, Long> {
}
