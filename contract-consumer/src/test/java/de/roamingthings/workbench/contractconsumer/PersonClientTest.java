package de.roamingthings.workbench.contractconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@SpringBootTest(webEnvironment = NONE)
@AutoConfigureStubRunner(
        ids = "de.roamingthings.workbench:contract-producer:+:8080",
        stubsMode = LOCAL
)
class PersonClientTest {

    @Autowired
    PersonClient personClient;

    @Test
    void should_retrieve_all_persons_from_producer() { // NOSONAR
        Person personOne = new Person("abc-123", "Paula Sorgenlos");
        Person personTwo = new Person("def-456", "Toni Tester");

        List<Person> persons = personClient.listAllPersons();

        assertThat(persons).containsExactly(personOne, personTwo);
    }
}
