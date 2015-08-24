package by.epam.project.web;

import by.epam.project.domain.*;
import by.epam.project.security.AuthUser;
import by.epam.project.service.ActivityService;
import by.epam.project.service.AttachmentService;
import by.epam.project.service.ProjectService;
import by.epam.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    ProjectService projectService;

    private Integer taskId;
    AuthUser user = new AuthUser();

    public String getPath() throws UnsupportedEncodingException {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
        String reponsePath = new File(pathArr[0]).getPath() + File.separatorChar;
        return reponsePath;
    }

    @RequestMapping(value = "/opentask/{id}", method = RequestMethod.GET)
    public String openProject(@PathVariable("id") Integer id) {
        taskId = id;
        return "redirect:/totask";
    }

    @RequestMapping("/totask")
    public String toMember(Map<String, Object> map) {
        Task task = taskService.getTask(taskId);
        map.put("task",task);
        map.put("login", user.getCurrentUser());
        map.put("listActivity",taskService.getTaskActivity(taskId));
        map.put("listAttachment", attachmentService.listAttachTask(taskId));
        map.put("listProject", projectService.getProjects(user.getCurrentUser()));
        return "task";
    }

    @RequestMapping(value = "/updatestatus", method = RequestMethod.POST)
    public @ResponseBody
    Status updateStatus(@RequestBody Integer id){

        taskService.updateTask(taskId, id);
        Status status=taskService.getTask(taskId).getStatus();

        System.out.println(status.getName());
        return status;
    }

    @RequestMapping("/toCreateActivity")
    public String toCreateActivity (Map<String, Object> map){
        map.put("activity", new Activity());
        return "/createActivity";
    }

    @RequestMapping(value = "/createActivity", method = RequestMethod.POST)
     public String createActivity(@ModelAttribute("duration") Integer duration, @ModelAttribute("comment") String comment){
        Task task = taskService.getTask(taskId);
        activityService.addActivity(duration, comment, task.getAssigment().getMember(),task.getAssigment());
        return "redirect:/totask";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm,@ModelAttribute("description") String description,
                       Model map) {

        try {
            MultipartFile file = uploadForm.getFile();
            String saveDirectory = getPath();
            String fileName = "";

            if (file != null) {
                fileName = file.getOriginalFilename();
                file.transferTo(new File(saveDirectory + fileName));
            }

            Task task = taskService.getTask(taskId);
            attachmentService.addAttachment(fileName,String.valueOf(file.getSize()),description,task.getProject(),task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/totask";
    }
}
