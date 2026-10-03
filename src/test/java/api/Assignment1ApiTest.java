package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1ApiTest {

    @Test
    public void verifyGetRequest() {

        Response response = RestAssured
                .get("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected status code 200"
        );

        Assert.assertTrue(
                response.getBody().asString().contains("userId"),
                "Response does not contain userId"
        );
    }
    @Test
public void verifyPostRequest() {

    String requestBody = """
            {
                "title": "QA Automation",
                "body": "API testing using RestAssured",
                "userId": 1
            }
            """;

    Response response = RestAssured
            .given()
            .contentType("application/json")
            .body(requestBody)
            .post("https://jsonplaceholder.typicode.com/posts");

    System.out.println("Status Code: " + response.getStatusCode());
    System.out.println("Response Body: " + response.getBody().asString());

    Assert.assertEquals(
            response.getStatusCode(),
            201,
            "Expected status code 201"
    );

    Assert.assertTrue(
            response.getBody().asString().contains("QA Automation"),
            "Response does not contain created title"
    );
}
@Test
public void verifyParametersAndHeaders() {

    Response response = RestAssured
            .given()
            .queryParam("userId", 1)
            .header("Accept", "application/json")
            .when()
            .get("https://jsonplaceholder.typicode.com/posts");

    System.out.println("Status Code: " + response.getStatusCode());
    System.out.println("Response Body: " + response.getBody().asString());

    Assert.assertEquals(
            response.getStatusCode(),
            200,
            "Expected status code 200"
    );

    Assert.assertTrue(
            response.getBody().asString().contains("\"userId\": 1"),
            "Response does not contain expected userId"
    );
}
}