package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.api.BaseApiTest;

import static io.restassured.RestAssured.given;

public class PostApiTest extends BaseApiTest {

    @Test
    public void missingTitle() {
        String requestBody = "{ \"body\": \"This is a test post\", \"userId\": 1 }";

        Response response = given()
                .log().all()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .log().all()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 201); // JSONPlaceholder always returns 201
        Assert.assertNull(response.jsonPath().get("title"), "Title should be missing");
    }
}
