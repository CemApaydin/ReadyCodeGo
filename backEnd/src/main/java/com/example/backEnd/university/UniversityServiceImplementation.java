package com.example.backEnd.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImplementation implements UniversityService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImplementation(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }


    @Override
    public University saveUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University findById(Long universityId) {
        return universityRepository.findById(universityId).orElse(null);
    }


    @Override
    public University findByName(String universityName) {
        return universityRepository.findByName(universityName);
    }
}
