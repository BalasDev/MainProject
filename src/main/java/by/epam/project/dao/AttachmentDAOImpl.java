package by.epam.project.dao;

import com.sun.xml.internal.ws.api.message.Attachment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AttachmentDAOImpl implements AttachmentDAO {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Attachment getAttachment(Integer id) {
        Attachment attachment =(Attachment) sessionFactory.getCurrentSession().get(Attachment.class, id);
        return attachment;
    }
}
