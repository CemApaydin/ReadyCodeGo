package com.example.backEnd.application;

import java.util.List;

public interface ApplicationService {
    public Application saveApplication(Application application);
    public List<Application> getAllApplications();
    public Application findById(Long userId);
}
