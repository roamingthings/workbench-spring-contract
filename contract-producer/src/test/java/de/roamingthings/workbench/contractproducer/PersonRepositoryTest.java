package de.roamingthings.workbench.contractproducer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonRepositoryTest {

    @Test
    void should_retrieve_list_of_persons() {
        PersonRepository personRepository = new PersonRepository();

        List<Person> personList = personRepository.findAllPersons();

        assertThat(personList).extracting("fullName").containsExactly("Paula Sorgenlos", "Toni Tester");
    }
}
