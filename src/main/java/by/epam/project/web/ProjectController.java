package by.epam.project.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ProjectController {


    @RequestMapping("/tocreateproject")
    public String home(Map<String, Object> map) {

        map.put()
        return "createproject";
    }
}
