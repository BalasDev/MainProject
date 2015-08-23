package by.epam.project.dao;

import by.epam.project.domain.Activity;
import by.epam.project.domain.Status;
import by.epam.project.domain.Task;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    @Autowired
    private SessionFactory sessionFactory;


    public Task getTask(Integer id) {
        Task task=(Task)sessionFactory.getCurrentSession().get(Task.class, id);
        return task;
    }


    public List<Task> getTaskLogin (String login) {
        String stringQuery = "select distinct t from Assigment a " +
                "inner join a.task t " +
                "inner join a.member m " +
                "inner join m.employee e " +
                "where e.login=:login";
        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
        query.setParameter("login", login);
        System.out.println("Current login is " + login);
        List<Task> tasks = query.list();
        return tasks;
    }


    public void updateTask(Integer taskId, Integer statusId) {

        Status status =(Status)sessionFactory.getCurrentSession().load(Status.class,statusId);
        Task task = getTask(taskId);
        task.setStatus(status);
        if(null!=task)
        sessionFactory.getCurrentSession().update(task);



    }

    public List<Activity> getTaskActivity (Integer id) {
        String stringQuery = "select distinct a from Activity a " +
                "inner join a.assigment s " +
                "inner join s.task t " +
                "where t.id=:id order by _DATE DESC";
        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
        query.setParameter("id", id);
        System.out.println("Current login is " + id);
        List<Activity> activities = query.list();
        return activities;
    }
}

