package by.epam.project.service;

import by.epam.project.dao.ProjectDAO;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    @Transactional
    public void addProject(Project project) {
        projectDAO.addProject(project);

    }

    @Transactional
    public List<Member> listMember() {
        return projectDAO.listMember();
    }

    @Transactional
    public List<Project> listProject() {
        return projectDAO.listProject();
    }
}
