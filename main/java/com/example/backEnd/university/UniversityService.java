package com.example.backEnd.university;

import java.util.List;

public interface UniversityService {
    public University saveUniversity(University university);
    public List<University> getAllUniversities();
    public University findById(Long universityId);
}
