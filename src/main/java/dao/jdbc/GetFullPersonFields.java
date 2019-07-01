package dao.jdbc;

import entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetFullPersonFields implements GetPersonStrategy {
    private static Logger logger = Logger.getLogger(GetPersonNameAndPhone.class.getName());

    private static final String SELECT_PERSON_SQL_TEMPLATE =
            "select id, name, birth_date, email, phone from person";

    @Override
    public List<Person> getList(Connection connection) {
        List<Person> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PERSON_SQL_TEMPLATE)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt(1));
                    person.setName(resultSet.getString(2));
                    person.setBirthDate(LocalDate.parse(resultSet.getString(3)));
                    person.setEmail(resultSet.getString(4));
                    person.setPhone(resultSet.getString(5));
                    result.add(person);
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "An exception occurred on the DAO layer.", e);
        }
        return result;
    }
}
