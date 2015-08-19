package by.epam.project.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class AuthUser {
    public String getCurrentUser()  {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

      /*  if (null == auth) {
            throw new NotFoundException("");
        }*/

        Object obj = auth.getPrincipal();
        String login = "";

        if (obj instanceof UserDetails) {
            login = ((UserDetails) obj).getUsername();
        } else {
            login = obj.toString();
        }

        return login;
    }
}
