package by.epam.project.dao;

import by.epam.project.domain.Activity;
import by.epam.project.domain.Task;
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

    public void addActivity(Task task,String comment,Integer duration) {
        Activity activity= new Activity();
        activity.setComment(comment);
        activity.setDuration(duration);
        activity.setAssigment(task.getAssigment());
        activity.setMember(task.getAssigment().getMember());
        sessionFactory.getCurrentSession().save(activity);
    }
}
