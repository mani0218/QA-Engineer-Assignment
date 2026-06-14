package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.api.BaseApiTest;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    @Test
    public void getUserById() {
        Response response = given()
                .log().all()
                .pathParam("id", 1)
                .when()
                .get("/users/{id}")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("id"), "1");
        Assert.assertEquals(response.jsonPath().getString("username"), "Bret");
    }
}
