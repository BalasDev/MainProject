package by.epam.project.web;

import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import by.epam.project.security.AuthUser;
import by.epam.project.security.CustomUserDetailService;
import by.epam.project.service.IssueService;
import by.epam.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private IssueService issueService;
    private int projectId;
    private int taskId;
    private AuthUser user = new AuthUser();


    @RequestMapping("/toprojectadministration")
    public String projectAdmin(Map<String, Object> map) {

         map.put("listProject",projectService.listProject());
        return "projectadministration";
    }

    @RequestMapping("/tocreateproject")
    public String toCreateProj(Map<String, Object> map) {

        map.put("project", new Project());
        map.put("listProject", projectService.getProjects(user.getCurrentUser()));
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

    @RequestMapping(value = "/openproject/{id}", method = RequestMethod.GET)
    public String openProject(@PathVariable("id") Integer id,Map<String, Object> map ) {
        projectId = id;
       return "redirect:/tomember";

    }


    @RequestMapping("/tomember")
    public String toMember(Map<String, Object> map) {
        map.put("memberList", projectService.listMember(projectId));
        map.put("project", projectService.getProject(projectId));
        map.put("listProject", projectService.getProjects(user.getCurrentUser()));
        return "projectmembers";
    }

    @RequestMapping("/toaddmember")
    public String toAddMember(Map<String, Object> map) {

        map.put("employeeList",projectService.listEmployee());
        map.put("roleList", projectService.listRole());
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

    @RequestMapping(value = "/getemployees", method = RequestMethod.POST)
    public @ResponseBody
    List<Employee> getEmpolyee(@RequestBody Integer id){
        List<Employee> employees = new ArrayList<Employee>();

        System.out.println(id);
        employees = issueService.getEmployee(id);
        for(Employee e:employees)
            System.out.println(e.getId());
        return employees;
    }

    @RequestMapping(value = "/createissue", method = RequestMethod.POST)
    public String createIssue(@RequestParam("project") Integer projectId,
                              @RequestParam("member") Integer employeeId,
                              @RequestParam("description") String description){

        System.out.println(projectId);
        System.out.println(employeeId);
        System.out.println(description);

        issueService.saveIssue(projectId, employeeId, description, user.getCurrentUser());

        return "redirect:/";
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public String projectView(@PathVariable("id") Integer id) {
        projectId=id;
       return "redirect:/tomember";
    }

    @RequestMapping(value ="/task/{id}", method = RequestMethod.GET)
    public String taskId(@PathVariable ("id") Integer id) {
        taskId=id;
        return "redirect:/taskView";
    }

    @RequestMapping(value = "/taskView", method = RequestMethod.GET)
    public String taskView(Map<String, Object> map){
        return "task";
    }
}
