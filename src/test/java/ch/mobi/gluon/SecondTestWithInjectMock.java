package ch.mobi.gluon;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
@Order(11)
//@TestProfile(TestWithInjectMock.DummyProfile.class) //Workaround to force separate inits of quarkus for the tests
class SecondTestWithInjectMock {

    @InjectMock
    @RestClient
    GreetingRestClient client;

    @Test
    public void testHelloEndpoint() {
        String mockHello = "Hello agian from Mock";
        when(client.hello()).thenReturn(mockHello);

        given()
                .when().get("/indirect/hello")
                .then()
                .statusCode(200)
                .body(is(mockHello + " (Indirect)"));
    }

}