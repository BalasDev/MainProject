package by.epam.project.service;


import by.epam.project.dao.EmployeeDAO;
import by.epam.project.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
   EmployeeDAO employeeDAO;

    @Transactional
    public Employee getEmployee(String login) {
        return employeeDAO.getEmployee(login);
    }
}
