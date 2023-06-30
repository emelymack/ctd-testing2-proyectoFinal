package com.RestAssured;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.RestAssured.testGetAccountsOverview.customerId;
import static com.RestAssured.testGetUser.password;
import static com.RestAssured.testGetUser.userDemo;
import static io.restassured.RestAssured.given;

public class testGetMonthlyAccountOverview {
    String url = "https://parabank.parasoft.com/parabank/services/bank/accounts/"+ customerId +"/transactions/month/All/type/All";

    @Test
    @DisplayName("Actividad de la cuenta (cada mes)")
    @Tag("TestCase-Back")
    public void getMonthlyAccountOverview() {
        Response res = given().auth()
                .basic(userDemo, password)
                .when()
                .get(url);

        int statusCode = res.getStatusCode();
        System.out.println(statusCode);

        Assert.assertEquals(200,statusCode);
        /* response: 200 */
    }
}
