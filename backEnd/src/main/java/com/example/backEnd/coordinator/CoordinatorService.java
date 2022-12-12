package com.example.backEnd.coordinator;

import java.util.List;

public interface CoordinatorService {
    public Coordinator saveCoordinator(Coordinator coordinator);
    public List<Coordinator> getAllCoordinators();
    public Coordinator findById(Long userId);
}
