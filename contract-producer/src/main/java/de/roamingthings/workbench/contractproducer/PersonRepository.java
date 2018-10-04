package de.roamingthings.workbench.contractproducer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;

@Service
public class PersonRepository {

    public List<Person> findAllPersons() {
        return asList(
                new Person(UUID.randomUUID().toString(), "Paula Sorgenlos"),
                new Person(UUID.randomUUID().toString(), "Toni Tester")
        );
    }
}
