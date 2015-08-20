package by.epam.project.service;


import by.epam.project.domain.Task;

import java.util.List;

public interface TaskService {
    public Task getTask(Integer id);
    public List<Task> getTaskList(String login);
}
