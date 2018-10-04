package de.roamingthings.workbench.contractproducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonResourceTest {

    @MockBean
    PersonRepository personRepository;

    @Autowired
    MockMvc mockMvc;

    private Person personOne = new Person("abc-123", "Paula Sorgenlos");
    private Person personTwo = new Person("def-456", "Toni Tester");

    @Test
    public void should_retrieve_list_of_persons_from_resource() throws Exception {
        stubPersonRepositoryReturningTwoPersons();

        ResultActions responseResult = mockMvc.perform(get("/persons"));

        responseResult
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("@.[0].id").value(personOne.getId()))
                .andExpect(jsonPath("@.[0].fullName").value(personOne.getFullName()))
                .andExpect(jsonPath("@.[1].id").value(personTwo.getId()))
                .andExpect(jsonPath("@.[1].fullName").value(personTwo.getFullName()));
    }

    private void stubPersonRepositoryReturningTwoPersons() {
        when(personRepository.findAllPersons()).thenReturn(
                asList(
                        personOne,
                        personTwo
                )
        );
    }
}
