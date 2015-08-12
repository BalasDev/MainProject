package by.epam.project.dao;

import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void addProject(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }


    public List<Member> listMember() {
        return sessionFactory.getCurrentSession().createQuery("from Member").list();
    }


    public List<Project> listProject() {
        return sessionFactory.getCurrentSession().createQuery("from Project").list();
    }
}
