package by.epam.project.service;

import by.epam.project.dao.TaskDAO;
import by.epam.project.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roma on 18.08.2015.
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskDAO taskDAO;

    @Transactional
    public Task getTask(Integer id){
        return taskDAO.getTask(id);
    }

    @Transactional
    public List<Task> getTaskList(String login){
        return taskDAO.getTaskLogin(login);
    }



}
