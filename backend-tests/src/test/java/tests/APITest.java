package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class APITest {

    @Test
    public void testGetRequest() {
        // Define a URL base da API (exemplo)
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Faz a requisição GET para o endpoint /todos
        Response response = RestAssured.given()
                                       .when()
                                       .get("/todos/1");

        // Verifica o status da resposta
        assertEquals(200, response.getStatusCode(), "Status Code should be 200");

        // Verifica um campo específico no JSON da resposta
        assertEquals(1, response.jsonPath().getInt("id"), "ID should be 1");
    }
}
