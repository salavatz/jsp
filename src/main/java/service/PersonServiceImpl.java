package service;

import dao.PersonDAO;
import dao.jdbc.GetFullPersonFields;
import dao.jdbc.GetPersonNameAndPhone;
import dao.jdbc.PersonDAOImpl;
import entity.Person;
import servlet.Strategy;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO;

    public PersonServiceImpl(Connection con, Strategy strategy) {
        if (strategy == Strategy.FULL) {
            personDAO = new PersonDAOImpl(con, new GetFullPersonFields());
        } else if (strategy == Strategy.NAME_AND_PHONE) {
            personDAO = new PersonDAOImpl(con, new GetPersonNameAndPhone());
        }
    }

    @Override
    public List<Person> getList() {
        return personDAO.getList();
    }

    @Override
    public boolean addPerson(String name, String birth, String email, String phone) {
        Person person = new Person();
        person.setName(name);
        LocalDate date = LocalDate.parse(birth);
        person.setBirthDate(date);
        person.setEmail(email);
        person.setPhone(phone);
        return personDAO.addPerson(person);
    }

}
