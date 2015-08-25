package by.epam.project.dao;

import by.epam.project.domain.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void addProject(Project project) {
        sessionFactory.getCurrentSession().save(project);
    }


    public List<Member> listMember(Integer id) {

        List<Member> members = new ArrayList<Member>();
        Query query = sessionFactory.getCurrentSession().createQuery("from Member  where PROJECTID = :id");
        query.setParameter("id", id);
        members = query.list();
        return members;
    }


    public List<Project> listProject() {
        return sessionFactory.getCurrentSession().createQuery("from Project").list();
    }


    public List<Employee> listEmployee() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }


    public List<Role> listRole() {
        return sessionFactory.getCurrentSession().createQuery("from Role").list();
    }


    public void addMember(Integer projId, Integer emplId, Integer roleId) {

        Project project = (Project) sessionFactory.getCurrentSession().load(Project.class, projId);
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, emplId);
        Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, roleId);

        Member member = new Member();
        member.setEmployee(employee);
        member.setProject(project);
        member.setRole(role);

        sessionFactory.getCurrentSession().save(member);
    }

    public List<Project> getProjects(String login) {
        String stringQuery = "select distinct p from Project p " +
                "left join p.employees e " +
                "where e.login=:login";
        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
        query.setParameter("login", login);
        List<Project> projects = query.list();
        return projects;
    }

    public Project getProject(Integer id) {
        Project project = (Project) sessionFactory.getCurrentSession().get(Project.class, id);
        return project;
    }

}
