package com.example.backEnd.application;


import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImplementation implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImplementation(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application addAttachment(Application application, AttachmentComponent attachmentComponent) {
        application.addToAttachments(attachmentComponent);
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application findById(Long userId) {
        return applicationRepository.findById(userId).orElse(null);
    }
}
