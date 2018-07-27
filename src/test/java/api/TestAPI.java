package api;

import api.userdata.Search;
import api.userdata.User;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static api.data.TokenHolder.getToken;
import static api.data.TokenHolder.setToken;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class TestAPI {

    @Test(priority = 1)
    public void check_Authorization_With_IncorrectData() {
        String randomString = RandomStringUtils.random(10, true, false);
        User user = new User(randomString, "pass");
        given()
                .contentType("application/json")
                .body(user)
        .when()
                .post("http://192.168.50.19:8060/staffhub/auth")
        .then()
                .assertThat()
                .statusCode(401)
                .body("errorCode", equalTo("401"))
                .body("errorDescription", equalTo("Неверные учетные данные"));
    }

    @Test(priority = 2)
    public void check_Authorization_With_CorrectData() {

        User user = new User("eugene.astashevich@gmail.com", "pass");

        ExtractableResponse<Response> response = given()
                .contentType("application/json")
                .body(user)
        .when()
                .post("http://192.168.50.19:8060/staffhub/auth")
        .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("token", notNullValue())
                .extract();
        setToken(response.body().jsonPath().get("token"));
    }

    @Test(priority = 3)
    public void check_Vacancy() {

        given()
                .contentType("application/json")
                .header("Authorization", getToken())
        .when()
                .get("http://192.168.50.19:8060/staffhub/vacancy/")
        .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .body("rows[0].company.specialization[0]", equalTo("IT сфера"));
    }



}
