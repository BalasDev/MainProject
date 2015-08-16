package by.epam.project.dao;


import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import by.epam.project.domain.Role;

import java.util.List;

public interface ProjectDAO {

    public void addProject(Project project);

    public List<Member> listMember(Integer id);

    public List<Project> listProject();

    public List<Employee> listEmployee();

    public List<Role> listRole();

    public void addMember(Integer projId,Integer emplId,Integer roleId);




}
