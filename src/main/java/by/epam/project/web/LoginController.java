package by.epam.project.web;

import by.epam.project.service.ServiceEmployee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

 ServiceEmployee serviceEmployee;

    @RequestMapping("/")
    public String sing() {
        return "singIn";
    }
}
