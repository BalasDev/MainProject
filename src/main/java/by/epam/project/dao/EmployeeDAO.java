package by.epam.project.dao;


import by.epam.project.domain.Employee;

public interface EmployeeDAO {
    Employee getEmployee(String login);
}
