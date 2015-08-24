package by.epam.project.dao;


import by.epam.project.domain.Activity;
import by.epam.project.domain.Attachment;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttachmentDAOImpl implements AttachmentDAO {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Attachment getAttachment(Integer id) {
        Attachment attachment =(Attachment) sessionFactory.getCurrentSession().get(Attachment.class, id);
        return attachment;
    }
    @Override
    public void addAttachment (Attachment attachment){
        sessionFactory.getCurrentSession().save(attachment);
    }

    @Override
    public List<Attachment> listAttachTask (Integer id){
        String stringQuery = "from Attachment where taskid =:id";
        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
        query.setParameter("id", id);
        List<Attachment> attachments = query.list();
        return attachments;
    }
}
