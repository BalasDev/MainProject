package by.epam.project.dao;


import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;

import java.util.List;

public interface IssueDAO {

    public List<Project> getProject(String login);

    public List<Employee>getEmployee(Integer id);
}
