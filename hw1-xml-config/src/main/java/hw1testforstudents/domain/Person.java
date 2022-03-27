package hw1testforstudents.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private final String surname;

    public final List <List<String>>  test = new ArrayList <>();

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "name+surname = " + this.name+" "+ this.surname;
    }
}
