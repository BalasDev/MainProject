package by.epam.project.web;

import by.epam.project.domain.Employee;
import by.epam.project.domain.Status;
import by.epam.project.domain.Task;
import by.epam.project.security.AuthUser;
import by.epam.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    private Integer taskId;
    AuthUser user = new AuthUser();

    @RequestMapping(value = "/opentask/{id}", method = RequestMethod.GET)
    public String openProject(@PathVariable("id") Integer id) {
        taskId = id;

        return "redirect:/totask";
    }

    @RequestMapping("/totask")
    public String toMember(Map<String, Object> map) {
        Task task = taskService.getTask(taskId);
        map.put("task",task);
        map.put("login",user.getCurrentUser());

        return "task";
    }

    @RequestMapping(value = "/updatestatus", method = RequestMethod.POST)
    public @ResponseBody
    Status updateStatus(@RequestBody Integer id){

        taskService.updateTask(taskId,id);
        Status status=taskService.getTask(taskId).getStatus();

        System.out.println(status.getName());
        return status;
    }
}
