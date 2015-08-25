package by.epam.project.dao;


import by.epam.project.domain.Activity;
import by.epam.project.domain.Task;

import java.util.List;

public interface TaskDAO {

    Task getTask(Integer id);

    List<Task> getTaskLogin(String login);

    void updateTask(Integer taskId, Integer statusId);

    List<Activity> getTaskActivity (Integer id);


}
