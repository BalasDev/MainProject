package by.epam.project.web;

import by.epam.project.domain.Activity;
import by.epam.project.domain.ActivityStream;
import by.epam.project.service.ActivityService;
import by.epam.project.service.AttachmentService;
import by.epam.project.service.EmployeeService;
import by.epam.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    Integer startElem;


    @RequestMapping("/")
    public String home(Map<String, Object> map) {
        //  map.put("attachment",attachmentService.getAttachment(1));
        map.put("task", taskService.getTask(1));
        map.put("listActivity", activityService.listActivity());
        startElem=1;
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
        List<Activity> activity2 = new ArrayList<Activity>();
        List<ActivityStream> activityStreams = new ArrayList<ActivityStream>();
        activity2.addAll(activity.subList(startElem, startElem+1));
        startElem=startElem+1;
        if (activity2!=null){
        for (Activity entry : activity2) {
            activityStreams.add(new ActivityStream(entry.getMember().getEmployee().getLastName(),
                    entry.getMember().getEmployee().getFirstName(),
                    entry.getMember().getProject().getName(),
                    entry.getAssigment().getTask().getDescription(),
                    entry.getComment(),
                    entry.getDate()));
        }}
        return activityStreams;
    }
}

