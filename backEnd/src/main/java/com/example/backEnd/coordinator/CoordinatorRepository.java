package com.example.backEnd.coordinator;

import com.example.backEnd.coordinator.Coordinator;
import com.example.backEnd.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorRepository extends UserRepository<Coordinator> {
}
