package by.epam.project.web;

import by.epam.project.service.ActivityService;
import by.epam.project.service.AttachmentService;
import by.epam.project.service.EmployeeService;
import by.epam.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("/")
    public String home(Map<String, Object> map) {
      //  map.put("attachment",attachmentService.getAttachment(1));
        map.put("task",taskService.getTask(1));
        map.put("listActivity",activityService.listActivity());
        return "dashboard";
    }

    @RequestMapping("/login")
    public String sing() {
        return "login";
    }
}

