package by.epam.project.dao;


import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;

import java.util.List;

public interface IssueDAO {

    List<Project> getProject(String login);

    List<Employee>getEmployee(Integer id);

    void saveIssue(Integer prId, Integer memId, String desc, String currentUser);
}
