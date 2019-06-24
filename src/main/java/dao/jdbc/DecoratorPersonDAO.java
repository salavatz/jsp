package dao.jdbc;

import dao.PersonDAO;
import entity.Person;

import java.util.List;

public class DecoratorPersonDAO implements PersonDAO {
    protected PersonDAO personDAO;

    public DecoratorPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> getList() {
        return personDAO.getList();
    }

    @Override
    public boolean addPerson(Person person) {
        return personDAO.addPerson(person);
    }
}
