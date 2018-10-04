import static org.springframework.cloud.contract.spec.Contract.make
import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.GET

make {

    description("Should return all Persons")
    request {
        url("/persons")
        method(GET)
    }
    response {
        body(
                """
                    [
                        {"id": "abc-123", "fullName": "Paula Sorgenlos"},
                        {"id": "def-456", "fullName": "Toni Tester"}
                    ]
                """
        )
        status(200)
        headers {
            contentType(applicationJsonUtf8())
        }
    }
}
