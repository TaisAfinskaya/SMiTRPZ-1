package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;


public class PersonTest {


    @Test
    public void checkSerializeUnSerialize() {
        Person originalPerson = new Person(1991, "Ivan", "Ivanov", 233244233);
        String serializedToJsonString = originalPerson.toJson();
        assertEquals(originalPerson, Person.fromJson(serializedToJsonString));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier
                .forClass(Person.class)
                .suppress(Warning.NULL_FIELDS)
                .verify();
    }
}
