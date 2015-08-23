package by.epam.project.service;


import by.epam.project.domain.Activity;
import by.epam.project.domain.Task;

import java.util.List;

public interface TaskService {

    public Task getTask(Integer id);

    public List<Task> getTaskList(String login);

    public void updateTask(Integer taskId, Integer statusId);

    public List<Activity> getTaskActivity (Integer id);
}
