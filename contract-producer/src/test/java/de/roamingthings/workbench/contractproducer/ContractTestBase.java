package de.roamingthings.workbench.contractproducer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PersonResource.class, webEnvironment = MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public abstract class ContractTestBase {

    @MockBean
    PersonRepository personRepository;

    @Autowired
    PersonResource personResource;

    private Person personOne = new Person("abc-123", "Paula Sorgenlos");
    private Person personTwo = new Person("def-456", "Toni Tester");

    @Before
    public void setupContractTest() {
        stubPersonRepositoryReturningTwoPersons();

        RestAssuredMockMvc.standaloneSetup(standaloneSetup(personResource));
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

