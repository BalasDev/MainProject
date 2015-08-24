package by.epam.project.dao;

import by.epam.project.domain.Employee;
import by.epam.project.domain.Position;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void createUser(String firstName, String lastName, String login, String password, Integer position) {
      Position positions = (Position)sessionFactory.getCurrentSession().load(Position.class, position);
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setLogin(login);
        employee.setPassword(password);
        employee.setPosition(positions);
      sessionFactory.getCurrentSession().save(employee);
    }
}
