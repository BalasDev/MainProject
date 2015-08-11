package by.epam.project.web;

import by.epam.project.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class LoginController {

 EmployeeService employeeService;




    @RequestMapping("/")
    public String home(Map<String, Object> map) {

        return "dashboard";
    }

    @RequestMapping("/login")
    public String sing() {
        return "login";
    }
}

