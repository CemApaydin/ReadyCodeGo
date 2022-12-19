package com.example.backEnd.attachment;

import com.example.backEnd.document.Document;

import java.util.List;

public interface AttachmentGroupService {
    public List<AttachmentGroup> getAllAttachments();
    public AttachmentGroup saveAttachmentGroup(AttachmentGroup newAttachmentGroup);
    public AttachmentComponent findById(Long attachmentId);
}
