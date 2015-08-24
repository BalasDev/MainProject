package by.epam.project.dao;

import by.epam.project.domain.Activity;
import by.epam.project.domain.Assigment;
import by.epam.project.domain.Member;
import jdk.nashorn.internal.ir.Assignment;
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
        return sessionFactory.getCurrentSession().createQuery("from Activity order by _DATE DESC").list();

    }

    public void addActivity(Integer duration, String comment, Member member, Assigment assignment) {

        Activity activity= new Activity();
        activity.setDuration(duration);
        activity.setComment(comment);
        activity.setMember(member);
        activity.setAssigment(assignment);

        sessionFactory.getCurrentSession().save(activity);
    }
}
