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


    @RequestMapping("/toprojectadministration")
    public String projectAdmin(Map<String, Object> map) {

         map.put("listProject",projectService.listProject());
        return "projectadministration";
    }

    @RequestMapping("/tocreateproject")
    public String toCreateProj(Map<String, Object> map) {

       // map.put("listMember",projectService.listMember());
        return "createproject";
    }
}
