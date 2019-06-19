package service;

import entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getList();

    boolean addPerson(String name, String birth);
}
