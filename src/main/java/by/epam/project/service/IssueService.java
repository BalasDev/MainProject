package by.epam.project.service;


import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;

import java.util.List;

public interface IssueService {

    public List<Project> getProject(String login);

    public List<Employee> getEmployee(Integer id);

}
