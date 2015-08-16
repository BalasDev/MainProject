package by.epam.project.service;


import by.epam.project.domain.Project;

import java.util.List;

public interface IssueService {

    public List<Project> getProject(String login);

}
