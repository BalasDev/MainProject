package by.epam.project.dao;


import by.epam.project.domain.Role;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Role getPosition(Integer id, String login) {

        Role role = new Role();

        String stringQuery = "Select r from Member m " +
                "inner join m.role r " +
                "inner join m.employee e " +
                "inner join m.project p " +
                "where p.id = :id " +
                "and e.login = :login";

        Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
        query.setParameter("id", id);
        query.setParameter("login", login);

        role = (Role) query.list().get(0);
        return role;
    }
}
