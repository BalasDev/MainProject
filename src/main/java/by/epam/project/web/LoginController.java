package by.epam.project.web;

import by.epam.project.domain.Activity;
import by.epam.project.domain.ActivityStream;
import by.epam.project.security.AuthUser;
import by.epam.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ActivityService activityService;
    @Autowired
    AttachmentService attachmentService;
    @Autowired
    TaskService taskService;
    @Autowired
    ProjectService projectService;
    private AuthUser user = new AuthUser();

    Integer startElem;
    Integer countShow = 1;


    @RequestMapping("/")
    public String home(Map<String, Object> map) {
        map.put("listActivity", activityService.listActivity());
        map.put("listTask", taskService.getTaskList(user.getCurrentUser()));
        map.put("listProject", projectService.getProjects(user.getCurrentUser()));
        startElem = countShow;
        return "dashboard";
    }

    @RequestMapping("/login")
    public String sing() {
        return "login";
    }

    @Transactional
    @RequestMapping(value = "/showMore", method = RequestMethod.POST)

    public
    @ResponseBody
    List<ActivityStream> showMore() {
        List<Activity> activity = activityService.listActivity();
        List<Activity> activityPart = new ArrayList<Activity>();
        List<ActivityStream> activityStreams = new ArrayList<ActivityStream>();
        Integer finishElem=startElem+countShow;
        while ((startElem < (finishElem)) && (startElem < activity.size())) {
            activityPart.addAll(activity.subList(startElem, startElem + 1));
            startElem++;
        }

        if (activityPart.size() != 0) {
            for (Activity entry : activityPart) {
                activityStreams.add(new ActivityStream(entry.getMember().getEmployee().getLastName(),
                        entry.getMember().getEmployee().getFirstName(),
                        entry.getMember().getProject().getName(),
                        entry.getAssigment().getTask().getDescription(),
                        entry.getComment(),
                        entry.getDate()));
            }
        }
        return activityStreams;
    }
}

