package by.epam.project.web;

import by.epam.project.domain.Task;
import by.epam.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/opentask/{id}", method = RequestMethod.GET)
    public String openProject(@PathVariable("id") Integer id,Map<String, Object> map ,ModelAndView modelAndView) {

        Task task = taskService.getTask(id);
        modelAndView.addObject("task",task);
        map.put("task",task);
        /*map.put("projectName",task.getProject().getName());*/

        return "task";
    }
}
