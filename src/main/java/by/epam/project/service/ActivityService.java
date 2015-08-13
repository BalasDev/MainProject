package by.epam.project.service;

import by.epam.project.domain.Activity;

import java.util.List;

public interface ActivityService {
    public Activity getActivity(Integer id);
    public List<Activity> listActivity();
}
