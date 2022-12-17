package com.example.backEnd.application;

import com.example.backEnd.document.Document;

import java.util.List;

public interface ApplicationService {
    public Application saveApplication(Application application);
    public Application addDocument(Application application, Document document);
    public List<Application> getAllApplications();
    public Application findById(Long userId);
}
