package com.example.backEnd.coordinator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatorServiceImplementation implements CoordinatorService{

    private final CoordinatorRepository coordinatorRepository;

    @Autowired
    public CoordinatorServiceImplementation(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    public Coordinator saveCoordinator(Coordinator coordinator) {
        return coordinatorRepository.save(coordinator);
    }

    @Override
    public List<Coordinator> getAllCoordinators() {
        return coordinatorRepository.findAll();
    }

    @Override
    public Coordinator findById(Long userId) {
        return coordinatorRepository.findById(userId).orElse(null);
    }
}
