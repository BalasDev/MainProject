package by.epam.project.security;

import by.epam.project.domain.Employee;
import by.epam.project.domain.Project;
import by.epam.project.domain.Role;
import by.epam.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private EmployeeService employeeService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = employeeService.getEmployee(login);
        return new User(employee.getLogin(), employee.getPassword(), true, true, true, true, buildUserAuthority(employee));
    }

    private List<GrantedAuthority> buildUserAuthority(Employee employee) {

        // Build user's authorities
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (employee.getLogin().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
       // System.out.println(employee.getPosition().getName());


        for (Project project : employee.getProjects()) {
            System.out.println(project.getName());
            for (Role role: project.getRoles()){
                System.out.println(employee.getPosition().getName()+" working on the project "+project.getName()+" into role "+role.getName());
            }
        }

        return authorities;

    }

}
