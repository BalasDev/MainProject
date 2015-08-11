package by.epam.project.service;

import by.epam.project.dao.ProjectDAO;
import by.epam.project.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    @Transactional
    public void addProject(Project project) {
        projectDAO.addProject(project);

    }
}
