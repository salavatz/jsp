package service;

import dao.UserDAO;
import dao.jdbc.UserDAOImpl;
import entity.User;

import java.sql.Connection;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private final UserDAO userDAO;

    public UserServiceImpl(Connection connection) {
        userDAO = new UserDAOImpl(connection);
    }

    @Override
    public boolean userIsExist(String login, String password) {
        return userDAO.userIsExist(login, password);
    }

    @Override
    public boolean addUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return userDAO.addUser(user);
    }
}
