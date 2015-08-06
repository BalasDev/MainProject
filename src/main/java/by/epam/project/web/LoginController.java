package by.epam.project.web;

import by.epam.project.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

 EmployeeService employeeService;

    @RequestMapping("/")
    public String sing() {
        return "login";
    }
}

