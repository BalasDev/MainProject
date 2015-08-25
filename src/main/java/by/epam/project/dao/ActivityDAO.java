package by.epam.project.dao;

import by.epam.project.domain.Activity;
import by.epam.project.domain.Assigment;
import by.epam.project.domain.Member;

import java.util.List;

public interface ActivityDAO {
    Activity getActivity (Integer id);
    List<Activity> listActivity();
    void addActivity(Integer duration, String comment, Member member, Assigment assignment);
}
