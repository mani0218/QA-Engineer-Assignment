package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.api.BaseApiTest;

import static io.restassured.RestAssured.given;

public class CommentApiTest extends BaseApiTest {

    @Test
    public void getCommentsByPostId() {
        Response response = given()
                .log().all()
                .pathParam("postId", 1)
                .when()
                .get("/posts/{postId}/comments")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        // Validate first comment fields
        Assert.assertEquals(response.jsonPath().getString("[0].postId"), "1");
        Assert.assertNotNull(response.jsonPath().getString("[0].email"), "Email should not be null");
    }
    @Test
    public void getCommentsInvalidPostId() {
        Response response = given()
                .log().all()
                .pathParam("postId", 99999) // Non-existent post
                .when()
                .get("/posts/{postId}/comments")
                .then()
                .log().all()
                .statusCode(200) // JSONPlaceholder returns 200 but empty array
                .extract().response();

        // Validate response is empty
        Assert.assertEquals(response.jsonPath().getList("$").size(), 0, "Expected no comments for invalid postId");
    }
}
