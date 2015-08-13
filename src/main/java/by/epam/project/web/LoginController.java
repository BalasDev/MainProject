package by.epam.project.web;

import by.epam.project.service.ActivityService;
import by.epam.project.service.EmployeeService;
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


    @RequestMapping("/")
    public String home(Map<String, Object> map) {
        map.put("listActivity",activityService.listActivity());
        return "dashboard";
    }

    @RequestMapping("/login")
    public String sing() {
        return "login";
    }
}

