package dao.jdbc;

import entity.Person;

import java.sql.Connection;
import java.util.List;

public abstract class GetPersonStrategy {
    protected final Connection connection;

    public GetPersonStrategy(Connection con) {
        this.connection = con;
    }

    protected abstract List<Person> getList();
}
