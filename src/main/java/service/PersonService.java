package service;

import entity.Person;
import servlet.Strategy;

import java.util.List;

public interface PersonService {

    List<Person> getList();

    boolean addPerson(String name, String birth, String email, String phone);

    Strategy getStrategy();

    void setStrategy(Strategy strategy);
}
