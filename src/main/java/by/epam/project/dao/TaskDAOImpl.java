package by.epam.project.dao;

import by.epam.project.domain.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDAOImpl implements TaskDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Task getTask(Integer id) {
        Task task=(Task)sessionFactory.getCurrentSession().get(Task.class, id);
        return task;
    }
}

