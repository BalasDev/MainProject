package by.epam.project.service;

import by.epam.project.dao.ActivityDAO;
import by.epam.project.domain.Activity;
import by.epam.project.domain.Task;
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
    public void addActivity(Task task,String comment,Integer duration){
        activityDAO.addActivity(task,comment,duration);
    }
        }
