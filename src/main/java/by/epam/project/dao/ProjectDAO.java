package by.epam.project.dao;


import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import by.epam.project.domain.Role;

import java.util.List;

public interface ProjectDAO {

    void addProject(Project project);

    List<Member> listMember(Integer id);

    List<Project> listProject();

    List<Employee> listEmployee();

    List<Role> listRole();

    void addMember(Integer projId,Integer emplId,Integer roleId);

    List<Project> getProjects (String login);

    Project getProject (Integer id);




}
