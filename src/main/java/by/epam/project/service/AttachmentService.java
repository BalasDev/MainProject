package by.epam.project.service;


import by.epam.project.domain.Attachment;

import java.util.List;

public interface AttachmentService {
    public Attachment getAttachment(Integer id);
    public void addAttachment(Attachment attachment);
    public List<Attachment> listAttachTask (Integer taskid);
}
