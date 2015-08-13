package by.epam.project.web;

import by.epam.project.domain.Project;
import by.epam.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

        map.put("project", new Project());
        return "createproject";
    }

    @RequestMapping("/createproject")
    public String createProj(@Valid Project project,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/createproject";
        }

        projectService.addProject(project);
        return "redirect:/toprojectadministration";

    }

    @RequestMapping(value = "/openproject/{id}", produces = "text/html", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") Integer id,Map<String, Object> map ) {
        map.put("memberList",projectService.listMember(id));
        System.out.println(projectService.listMember(id).get(0).getEmployee().getFirstName());
        // memberlist personalService.deletePersonal(id);
       return "projectmembers";
    }





}
