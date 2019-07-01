package dao.jdbc;

import entity.Person;

import java.sql.Connection;
import java.util.List;

public interface GetPersonStrategy {

    List<Person> getList(Connection connection);

}
