package at.htl.services.car.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EmployeeControllerTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/cardealer")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}