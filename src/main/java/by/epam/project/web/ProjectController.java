package by.epam.project.web;

import by.epam.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @RequestMapping("/tocreateproject")
    public String home(Map<String, Object> map) {

        map.put("listMember",projectService.listMember());
        return "createproject";
    }
}
