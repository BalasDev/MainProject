package by.epam.project.dao;


import by.epam.project.domain.Project;

import java.util.List;

public interface IssueDAO {

    public List<Project> getProject(String login);
}
