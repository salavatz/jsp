package dao.jdbc;

import dao.PersonDAO;
import entity.Person;

import java.util.List;

public class ExtendedPersonDAOImpl extends DecoratorPersonDAO {

    public ExtendedPersonDAOImpl(PersonDAO personDAO) {
        super(personDAO);
    }

    @Override
    public List<Person> getList() {
        List<Person> persons = personDAO.getList();
        for (Person person : persons) {
            person.setPhone(person.getPhone().replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "$1-($2)-$3-$4-$5"));
        }
        return persons;
    }
}
