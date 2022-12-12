package com.example.backEnd.waitingbin;
import com.example.backEnd.waitingbin.WaitingBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingBinRepository extends JpaRepository<WaitingBin, Long> {
}
