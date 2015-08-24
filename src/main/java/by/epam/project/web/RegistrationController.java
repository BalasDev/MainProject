package by.epam.project.web;

import by.epam.project.domain.Project;
import by.epam.project.service.PositionService;
import by.epam.project.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    private PositionService positionService;

    @RequestMapping("/touserregistration")
    public String toUserRegistration(Map<String, Object> map){
      map.put("positions",positionService.listPosition());

      return "registration";
    }

    @RequestMapping(value = "/createuser", method = RequestMethod.POST)
    public String createProj(@RequestParam("inputFirstName") String firstName,
                             @RequestParam("inputLastName") String lastName,
                             @RequestParam("inputLogin") String login,
                             @RequestParam("inputPassword") String password,
                             @RequestParam("inputConfirmPassword") String confirmPassword,
                             @RequestParam("position") Integer position) {

        if(!password.equals(confirmPassword)){
            return "redirect:/touserregistration";
        }
        else{
         registrationService.createUser(firstName,lastName,login,password,position);
            return "redirect:/";
        }
        }

}
