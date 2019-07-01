package dao.jdbc;

import dao.PersonDAO;
import entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDAOImpl implements PersonDAO {
    private static Logger logger = Logger.getLogger(PersonDAOImpl.class.getName());
    private final Connection connection;
    GetPersonStrategy strategy;

    public PersonDAOImpl(Connection con, GetPersonStrategy strategy) {
        this.connection = con;
        this.strategy = strategy;
    }

    private static final String INSERT_PERSON_SQL_TEMPLATE =
            "insert into person (name, birth_date, email, phone) values (?, ?, ?, ?)";

    @Override
    public List<Person> getList() {
        return strategy.getList(connection);
    }

    @Override
    public boolean addPerson(Person person) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PERSON_SQL_TEMPLATE)) {
            statement.setString(1, person.getName());
            if (person.getBirthDate() == null) {
                statement.setNull(2, Types.BIGINT);
            } else {
                statement.setString(2, person.getBirthDate().toString());
            }
            statement.setString(3, person.getEmail());
            statement.setString(4, person.getPhone());
            statement.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
            return false;
        }
    }
}
