package by.epam.project.dao;

import by.epam.project.domain.Activity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Activity getActivity(Integer id) {
        Activity activity = (Activity) sessionFactory.openSession().get(Activity.class, id);
        return activity;
    }
}
