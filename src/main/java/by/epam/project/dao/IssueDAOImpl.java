package by.epam.project.dao;

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

        String stringQuery = "select distinct  p from Project p " +

                "inner join p.employees  e " +
                "inner join p.roles r " +
                "where r.name in (:role1,:role2,:role3) " +
                "and e.login=:login";


                /*+
                "WHERE Project.roles.getName in (:role1,:role2,:role3) " +
                "and Project.Employee.LOGIN =:login"*/;
        List<Project> projects = new ArrayList<Project>();

        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
        query.setParameter("login",login);
        query.setParameter("role1","Teamlead");
        query.setParameter("role2","Project Manager");
        query.setParameter("role3","manadger");
        projects = query.list();
        return projects;
    }
}
