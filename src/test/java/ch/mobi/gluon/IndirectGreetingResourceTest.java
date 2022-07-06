package ch.mobi.gluon;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@Order(100)
class IndirectGreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        //this test will fail if AAA_Runfirst_IndirectGreetingResourceWithMockTest was executed first
        given()
                .when().get("/indirect/hello")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive (Indirect)"));
    }

}