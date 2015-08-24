package by.epam.project.dao;


public interface RegistrationDAO {

    public void createUser(String firstName,String lastName,String login, String password,Integer position);
}
