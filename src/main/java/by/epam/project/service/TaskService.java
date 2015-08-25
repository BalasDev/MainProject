package by.epam.project.service;


import by.epam.project.domain.Activity;
import by.epam.project.domain.Task;

import java.util.List;

public interface TaskService {

    Task getTask(Integer id);

    List<Task> getTaskList(String login);

    void updateTask(Integer taskId, Integer statusId);

    List<Activity> getTaskActivity (Integer id);
}
