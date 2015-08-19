package by.epam.project.dao;

import by.epam.project.domain.Activity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Activity getActivity(Integer id) {
        Activity activity = (Activity) sessionFactory.getCurrentSession().get(Activity.class, id);
        return activity;
    }

    public List<Activity> listActivity(){
        return sessionFactory.getCurrentSession().createQuery("from Activity order by _DATE DESC").list();
    }
}
