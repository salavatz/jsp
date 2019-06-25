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
import java.util.logging.Logger;

public class PersonServiceImpl implements PersonService {
    private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());
    private PersonDAO personDAO;
    private Strategy strategy;

    public PersonServiceImpl(Connection con, Strategy strategy) {
        if (strategy == Strategy.FULL) {
            personDAO = new PersonDAOImpl(con, new GetFullPersonFields(con));
        }
        else if (strategy == Strategy.NAME_AND_PHONE){
            personDAO = new PersonDAOImpl(con, new GetPersonNameAndPhone(con));
        }
    }

    @Override
    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
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
