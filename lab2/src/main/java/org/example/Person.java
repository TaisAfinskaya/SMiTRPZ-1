package org.example;

import com.google.gson.Gson;

import java.util.Objects;

public final class Person {

    private final int yearOfBirth;
    private final String firstName;
    private final String secondName;
    private final long inn;

    private final static Gson gson = new Gson();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yearOfBirth == person.yearOfBirth &&
                inn == person.inn &&
                firstName.equals(person.firstName) &&
                secondName.equals(person.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfBirth, firstName, secondName, inn);
    }

    public Person(int yearOfBirth, String firstName, String secondName, long inn) {
        this.yearOfBirth = yearOfBirth;
        this.firstName = firstName;
        this.secondName = secondName;
        this.inn = inn;
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public static Person fromJson(String jsonString) {
        return gson.fromJson(jsonString, Person.class);
    }
}
