package by.epam.project.dao;

import by.epam.project.domain.Position;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PositionDAOImpl implements PositionDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Position> listPosition() {
        return sessionFactory.getCurrentSession().createQuery("from Position").list();
    }
}
