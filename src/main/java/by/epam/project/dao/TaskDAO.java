package by.epam.project.dao;


import by.epam.project.domain.Task;

import java.util.List;

public interface TaskDAO {

    public Task getTask(Integer id);

    public List<Task> getTaskLogin(String login);

    public void updateTask(Integer taskId, Integer statusId);


}
