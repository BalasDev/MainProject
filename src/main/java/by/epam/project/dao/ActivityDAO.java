package by.epam.project.dao;

import by.epam.project.domain.Activity;

import java.util.List;

public interface ActivityDAO {
    public Activity getActivity (Integer id);
    public List<Activity> listActivity();
}
