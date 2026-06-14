package base.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

public class BaseApiTest {

    @BeforeClass
    public void apiSetup() {
        // Load base URI from config file
        RestAssured.baseURI = ConfigReader.get("baseURI");

        // Optional: set common headers or authentication here
        RestAssured.useRelaxedHTTPSValidation();
    }
}
