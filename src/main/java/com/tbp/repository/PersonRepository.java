package com.tbp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PersonRepository {

    static Map<String, Person> personMap;

    static {
        Person john = new Person("John", 20, "Rio de Janeiro");
        Person mary = new Person("Mary", 22, "New York");
        Person andrew = new Person("Andrew", 30, "London");

        personMap = new HashMap<String, Person>();
        personMap.put(john.getName(), john);
        personMap.put(mary.getName(), mary);
        personMap.put(andrew.getName(), andrew);
    }

    public List<Person> findAll() {
        List<Person> personList = new ArrayList<Person>();
        personList.addAll(personMap.values());
        return personList;
    }

    public void save(Person person) {
        personMap.put(person.getName(), person);
    }

    public void delete(String name) {
        personMap.remove(name);
    }

    public Person getByName(String name) {
        return personMap.get(name);
    }
}
