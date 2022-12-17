package com.example.backEnd.attachment;

import com.example.backEnd.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/attachmentgroup")
public class AttachmentGroupController {
    private final AttachmentGroupService attachmentGroupService;

    @Autowired
    public AttachmentGroupController(AttachmentGroupService attachmentGroupService) {
        this.attachmentGroupService = attachmentGroupService;
    }

    @GetMapping("/findAll")
    public List<AttachmentGroup> getAllAttachmentGroups()
    {
        return attachmentGroupService.getAllAttachments();
    }

    @PostMapping("/createAttachmentGroup")
    public String createAttachmentGroup(@RequestBody AttachmentGroup newAttachmentGroup)
    {
        attachmentGroupService.saveAttachmentGroup(newAttachmentGroup);
        return "Adding Done!!";
    }
    @GetMapping("/{attachmentId}")
    public AttachmentComponent getOneAttachment(@PathVariable Long attachmentId)
    {
        return attachmentGroupService.findById(attachmentId);
    }
    @GetMapping("/attachmentGroup/{attachmentId}")
    public AttachmentComponent getOneAttachmentA(@PathVariable Long attachmentId)
    {
        return attachmentGroupService.findById(attachmentId);
    }

}
