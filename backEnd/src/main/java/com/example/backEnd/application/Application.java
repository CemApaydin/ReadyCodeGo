package com.example.backEnd.application;

import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.attachment.AttachmentGroup;
import com.example.backEnd.document.Document;
import com.example.backEnd.university.University;
import com.example.backEnd.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Set;

@Entity
@Table(name="application")
@Data
@CrossOrigin
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationID;
    private String applicationStatus;
    @ElementCollection
    private Set<Long> appliedUniversityIds;
    @OneToOne(cascade = {CascadeType.ALL})
    private AttachmentGroup attachmentGroup;

    public Application( String applicationStatus, Set<Long> appliedUniversityIds) {
        this.applicationStatus = applicationStatus;
        this.appliedUniversityIds = appliedUniversityIds;
        attachmentGroup = new AttachmentGroup();
    }

    public Application() {
        this.applicationStatus = "Pending";
        this.appliedUniversityIds = null;
        attachmentGroup = new AttachmentGroup();
    }

    public Long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Long applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Set<Long> getAppliedUniversityIds() {
        return appliedUniversityIds;
    }

    public void setAppliedUniversityIds(Set<Long> appliedUniversityIds) {
        this.appliedUniversityIds = appliedUniversityIds;
    }

    public AttachmentGroup getAttachmentGroup() {
        return attachmentGroup;
    }

    public void setAttachmentGroup(AttachmentGroup attachmentGroup) {
        this.attachmentGroup = attachmentGroup;
    }

    public void addToAttachments(AttachmentComponent attachmentComponent) {
        attachmentGroup.addComponent(attachmentComponent);
    }
}
