package by.epam.project.service;

import by.epam.project.dao.RegistrationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationDAO registrationDAO;

    @Transactional
    public void createUser(String firstName, String lastName, String login, String password, Integer position) {

        registrationDAO.createUser(firstName,lastName,login,password,position);
    }
}
