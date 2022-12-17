package com.example.backEnd.attachment;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "attachmentcomponent")
@Data
@CrossOrigin
public class AttachmentComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    public AttachmentComponent() {
    }

    public Long getAttachmentId(){
        return attachmentId;
    }
    public void setAttachmentId(Long documentId){
        throw new UnsupportedOperationException();
    }
    public String getUploadDate(){
        throw new UnsupportedOperationException();
    }
    public void setUploadDate(String uploadDate){
        throw new UnsupportedOperationException();
    }
    public Long getUploaderId(){
        throw new UnsupportedOperationException();
    }
    public void setUploaderId(Long uploaderId){
        throw new UnsupportedOperationException();
    }
}
