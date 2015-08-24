package by.epam.project.dao;

import by.epam.project.domain.Activity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ActivityDAOImpl implements ActivityDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Activity getActivity(Integer id) {
        Activity activity = (Activity) sessionFactory.getCurrentSession().get(Activity.class, id);
        return activity;
    }

    public List<Activity> listActivity() {
        //List<Activity> activities = new ArrayList<Activity>();
        return sessionFactory.getCurrentSession().createQuery("from Activity order by _DATE DESC").list();

    }

    public void addActivity(Activity activity) {
        sessionFactory.getCurrentSession().save(activity);
    }
}
