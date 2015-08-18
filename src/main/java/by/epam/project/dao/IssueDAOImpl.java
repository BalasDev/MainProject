package by.epam.project.dao;

import by.epam.project.domain.Employee;
import by.epam.project.domain.Member;
import by.epam.project.domain.Project;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueDAOImpl implements IssueDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Project> getProject(String login) {

        String stringQueryProject = "select distinct  p from Project p " +

                "left join p.employees  e " +
                "left join p.roles r " +
                "where r.name in (:role1,:role2,:role3) " +
                "and e.login=:login";
        List<Project> projects = new ArrayList<Project>();

        Query query = sessionFactory.getCurrentSession().createQuery(stringQueryProject);
        query.setParameter("login",login);
        query.setParameter("role1","Teamlead");
        query.setParameter("role2","Project Manager");
        query.setParameter("role3","manadger");//change manadger to Manager
        projects = query.list();
        return projects;
    }


    public List<Employee> getEmployee(Integer id) {

        String stringQueryEmployee = "select e from Employee e " +
                "left join e.projects p " +
                "where p.id=:id" ;
        List<Employee> employees = new ArrayList<Employee>();
        Query query = sessionFactory.getCurrentSession().createQuery(stringQueryEmployee);
        query.setParameter("id",id);
        employees = query.list();
        return employees;
    }
}
