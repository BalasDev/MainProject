package by.epam.project.service;

import by.epam.project.domain.Activity;
import by.epam.project.domain.Task;

import java.util.List;

public interface ActivityService {
    public Activity getActivity(Integer id);
    public List<Activity> listActivity();
    public void addActivity(Task task,String comment,Integer duration);
}
