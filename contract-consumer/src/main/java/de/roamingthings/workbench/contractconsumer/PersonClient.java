package de.roamingthings.workbench.contractconsumer;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonClient {

    private final RestTemplate restTemplate;

    public List<Person> listAllPersons() {
        return restTemplate.exchange(
                "http://localhost:8080/persons",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Person>>() {
                })
                .getBody();
    }
}
