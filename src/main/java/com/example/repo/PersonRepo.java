package com.example.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Person;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepo {

    private static List<Person> list = new ArrayList<Person>();

    static {
        list.add(new Person(1, "Person A", "1975-11-27"));
        list.add(new Person(2, "Person B", "1980-05-24"));
        list.add(new Person(3, "Person C","1990-08-09"));
    }

    public void getAll() {
        for (Person person : list) {
            list.add(person);
        }
    }

    public List<Person> listPerson() {
        return list;
    }

    public List<Person> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }

    public String add(Person p) {
        Person obj = new Person();
        obj.setId(p.getId());
        obj.setName(p.getName());
        obj.setBirthDay(p.getBirthDay());

        list.add(obj);
        return null;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public String edit(Person person) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (person.getId())) {
                id = person.getId();
                idx = i;
                break;
            }
        }

        Person p = new Person();
        p.setId(id);
        p.setName(person.getName());
        p.setBirthDay(person.getBirthDay());
        list.set(idx, p);

        return null;
    }
}
