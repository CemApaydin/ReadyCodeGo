package com.example.backEnd.application;

import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.document.Document;

import java.util.List;

public interface ApplicationService {
    public Application saveApplication(Application application);
    public Application addAttachment(Application application, AttachmentComponent attachmentComponent);
    public List<Application> getAllApplications();
    public Application findById(Long userId);
}
