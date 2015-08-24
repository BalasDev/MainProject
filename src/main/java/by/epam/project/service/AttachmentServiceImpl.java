package by.epam.project.service;


import by.epam.project.dao.AttachmentDAO;

import by.epam.project.domain.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    AttachmentDAO attachmentDAO;

    @Transactional
    public Attachment getAttachment(Integer id) {
        return attachmentDAO.getAttachment(id);
    }

    @Transactional
    public void addAttachment (Attachment attachment) {
        attachmentDAO.addAttachment(attachment);
    }

    @Transactional
    public List<Attachment> listAttachTask (Integer id){
        return attachmentDAO.listAttachTask(id);
    }
}
