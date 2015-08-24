package by.epam.project.service;

import by.epam.project.domain.Activity;
import by.epam.project.domain.Assigment;
import by.epam.project.domain.Member;

import java.util.List;

public interface ActivityService {
    public Activity getActivity(Integer id);
    public List<Activity> listActivity();
    public void addActivity(Integer duration, String comment, Member member, Assigment assignment);
}
