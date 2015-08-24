package by.epam.project.dao;


import by.epam.project.domain.Attachment;

import java.util.List;

public interface AttachmentDAO {
    public Attachment getAttachment (Integer id);
    public void addAttachment (Attachment attachment);
    public List<Attachment> listAttachTask (Integer id);
}
