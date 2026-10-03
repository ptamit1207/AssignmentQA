package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTest {

    @Test
    public void verifyGetPostsStatusCode() {

        Response response = RestAssured
                .get("https://jsonplaceholder.typicode.com/posts");

        System.out.println("Status Code: " + response.getStatusCode());

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Expected status code 200"
        );
    }

    @Test
public void verifyResponseIsArray() {

    Response response = RestAssured
            .get("https://jsonplaceholder.typicode.com/posts");

    String responseBody = response.getBody().asString();

    System.out.println("Response Body: " + responseBody);

    Assert.assertTrue(
            responseBody.trim().startsWith("["),
            "Response body is not an Array"
    );

}
@Test
public void verifyInvalidEndpointStatusCode() {

    Response response = RestAssured
            .get("https://jsonplaceholder.typicode.com/postsss");

    System.out.println("Status Code: " + response.getStatusCode());

    Assert.assertEquals(
            response.getStatusCode(),
            404,
            "Expected status code 404"
    );
}
}