package com.example.backEnd.attachment;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "attachmentgroup")
@Data
@CrossOrigin
public class AttachmentGroup extends AttachmentComponent {
    private String uploadDate;
    private Long uploaderId;
    @OneToMany
    private List<AttachmentComponent> attachmentComponents;

    public AttachmentGroup() {
    }

    public AttachmentGroup(String uploadDate, Long uploaderId) {
        this.uploadDate = uploadDate;
        this.uploaderId = uploaderId;
        attachmentComponents = new ArrayList<AttachmentComponent>();
    }

    public void addComponent(AttachmentComponent attachmentComponent){
        attachmentComponents.add(attachmentComponent);
    }

    @Override
    public Long getAttachmentId() {
        return super.getAttachmentId();
    }

    @Override
    public String getUploadDate() {
        return uploadDate;
    }

    @Override
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public Long getUploaderId() {
        return uploaderId;
    }

    @Override
    public void setUploaderId(Long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public List<AttachmentComponent> getAttachmentComponents() {
        return attachmentComponents;

    }

    public void setAttachmentComponents(List<AttachmentComponent> attachmentComponents) {
        this.attachmentComponents = attachmentComponents;
    }
}
