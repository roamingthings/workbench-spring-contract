package de.roamingthings.workbench.contractproducer;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void should_create_person() {
        Person person = new Person(UUID.randomUUID().toString(), "Toni Tester");

        assertThat(person.getId()).isNotNull();
        assertThat(person.getFullName()).isEqualTo("Toni Tester");
    }
}
