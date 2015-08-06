package by.epam.project.dao;


import by.epam.project.domain.Employee;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Employee getEmployee(String login) {
        List<Employee> employees = new ArrayList<Employee>();
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee e where e.login =:login ");
        query.setParameter("login", login);
        employees = query.list();
        if (employees.size() > 0)
            return employees.get(0);
        else
            return null;
    }

}
