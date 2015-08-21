package by.epam.project.service;

import by.epam.project.dao.ProjectDAO;
import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import by.epam.project.domain.Role;
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
    public List<Member> listMember(Integer id) {
        return projectDAO.listMember(id);
    }

    @Transactional
    public List<Project> listProject() {
        return projectDAO.listProject();
    }

    @Transactional
    public List<Employee> listEmployee() {
        return projectDAO.listEmployee();
    }

    @Transactional
    public List<Role> listRole() {
        return projectDAO.listRole();
    }

    @Transactional
    public void addMember(Integer projId, Integer emplId, Integer roleId) {
        projectDAO.addMember(projId,emplId,roleId);

    }

    @Transactional
    public List<Project> getProjects(String login) {
       return projectDAO.getProjects(login);
    }

    @Transactional
    public Project getProject(Integer id){
        return projectDAO.getProject(id);
    }
}
