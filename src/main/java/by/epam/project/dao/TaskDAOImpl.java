package by.epam.project.dao;

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

    @Override
    public Task getTask(Integer id) {
        Task task=(Task)sessionFactory.getCurrentSession().get(Task.class, id);
        return task;
    }

    @Override
    public List<Task> getTaskLogin (String login) {
        /*String stringQuery = "select distinct t from Task t " +
                "left join t.project p " +
                "left join p.employees e " +
                "where e.login=:login";*/
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
}

