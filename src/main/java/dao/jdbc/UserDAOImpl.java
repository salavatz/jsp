package dao.jdbc;

import dao.UserDAO;
import entity.User;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {

    private static Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    private static final String INSERT_USER_SQL_TEMPLATE =
            "insert into user (login, password) values (?, ?)";
    private static final String SELECT_USER_SQL_TEMPLATE =
            "select login, password from user where login = ? and password = ?";

    @Override
    public boolean userIsExist(String login, String password) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_USER_SQL_TEMPLATE)) {
            statement.setString(1, login);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUser(User user) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL_TEMPLATE)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
            return false;
        }
    }
}
