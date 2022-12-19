package com.example.backEnd.attachment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentGroupServiceImplementation implements AttachmentGroupService{
    private final AttachmentGroupRepository attachmentGroupRepository;
    private final AttachmentComponentRepository attachmentComponentRepository;

    public AttachmentGroupServiceImplementation(AttachmentGroupRepository attachmentGroupRepository, AttachmentComponentRepository attachmentComponentRepository) {
        this.attachmentGroupRepository = attachmentGroupRepository;
        this.attachmentComponentRepository = attachmentComponentRepository;
    }

    @Override
    public List<AttachmentGroup> getAllAttachments() {
        return attachmentGroupRepository.findAll();
    }

    @Override
    public AttachmentGroup saveAttachmentGroup(AttachmentGroup newAttachmentGroup) {
        return attachmentGroupRepository.save(newAttachmentGroup);
    }

    @Override
    public AttachmentComponent findById(Long attachmentId) {
        return attachmentComponentRepository.findById(attachmentId).orElse(null);
    }
}
