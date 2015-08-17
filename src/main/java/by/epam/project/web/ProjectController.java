package by.epam.project.web;

import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import by.epam.project.security.CustomUserDetailService;
import by.epam.project.service.IssueService;
import by.epam.project.service.ProjectService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private IssueService issueService;
    private int projectId;
    private CustomUserDetailService user = new CustomUserDetailService();


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

    @RequestMapping(value = "/createproject", method = RequestMethod.POST)
    public String createProj(@Valid Project project,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/createproject";
        }

        projectService.addProject(project);
        return "redirect:/toprojectadministration";

    }

    @RequestMapping(value = "/openproject/{id}", produces = "text/html", method = RequestMethod.GET)
    public String openProject(@PathVariable("id") Integer id,Map<String, Object> map ) {
      //  map.put("id", id);
        projectId = id;
       return "redirect:/tomember";
    }


    @RequestMapping("/tomember")
    public String toMember(/*Integer id,*/Map<String, Object> map) {



        map.put("memberList", projectService.listMember(projectId));
       // map.put("projectName", projectService.listMember(projectId).get(0).getProject().getName());
        return "projectmembers";
    }

    @RequestMapping("/toaddmember")
    public String toAddMember(Map<String, Object> map) {

        map.put("employeeList",projectService.listEmployee());
        map.put("roleList",projectService.listRole());
        return "createmember";
    }

    @RequestMapping(value = "/addmember", method = RequestMethod.POST)
    public String addMember(@RequestParam("employeeId") Integer empId,
                            @RequestParam("roleId") Integer roleId) {
        projectService.addMember(projectId, empId, roleId);

        return "redirect:/tomember";
    }

    @RequestMapping("/tocreateissue")
    public String toCreateIssue(Map<String, Object> map){
        System.out.println(user.getCurrentUser());
        map.put("projectList", issueService.getProject(user.getCurrentUser()));

        return "createissue";
    }

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public @ResponseBody
    List<Member> getMembers(@RequestParam Integer id){

        return issueService.getMember(id);
    }

}
