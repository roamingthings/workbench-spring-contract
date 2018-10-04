package de.roamingthings.workbench.contractproducer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequiredArgsConstructor
public class PersonResource {

    private final PersonRepository personRepository;

    @GetMapping(value = "/persons", produces = APPLICATION_JSON_UTF8_VALUE)
    public List<Person> listAllPersons() {
        return personRepository.findAllPersons();
    }

}
