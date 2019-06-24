package service;

import dao.PersonDAO;
import dao.jdbc.PersonDAOImpl;
import entity.Person;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class PersonServiceImpl implements PersonService {
    private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());
    private final PersonDAO personDAO;

    public PersonServiceImpl(Connection con) {
        personDAO = new PersonDAOImpl(con);
    }

    @Override
    public List<Person> getList() {
        return personDAO.getList();
    }

    @Override
    public boolean addPerson(String name, String birth, String email, String phone) {
        Person person = new Person.Builder(name, LocalDate.parse(birth), email).
                withPhone(phone).build();
        return personDAO.addPerson(person);
    }

}
