package com.example.backEnd.document;

import com.example.backEnd.attachment.AttachmentComponent;
import com.example.backEnd.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "document")
@Data
@CrossOrigin
public class Document extends AttachmentComponent {
    private String uploadDate;
    private Long uploaderId;

    public Document( String uploadDate, Long uploaderId) {
        super();
        this.uploadDate = uploadDate;
        this.uploaderId = uploaderId;
    }

    public Document() {
        super();
        this.uploadDate = null;
        this.uploaderId = null;
    }
    public  Long getAttachmentId(){
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

}
