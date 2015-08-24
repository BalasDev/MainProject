package by.epam.project.service;

import by.epam.project.dao.ActivityDAO;
import by.epam.project.domain.Activity;
import by.epam.project.domain.Task;
import by.epam.project.domain.Assigment;
import by.epam.project.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityDAO activityDAO;

    @Transactional
    public Activity getActivity(Integer id) {
        return activityDAO.getActivity(id);
    }

    @Transactional
    public List<Activity> listActivity(){
        return activityDAO.listActivity();
    }

    @Transactional
    public void addActivity(Integer duration, String comment, Member member, Assigment assignment) {
        activityDAO.addActivity(duration, comment, member, assignment);
    }
        }
