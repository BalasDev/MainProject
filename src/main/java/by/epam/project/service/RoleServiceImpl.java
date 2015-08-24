package by.epam.project.service;

import by.epam.project.dao.RoleDAO;
import by.epam.project.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Transactional
    public Role getPosition(Integer id, String login) {
        return roleDAO.getPosition(id,login);
    }
}
