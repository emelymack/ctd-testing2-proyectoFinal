package com.RestAssured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static com.RestAssured.testGetUser.userDemo;
import static com.RestAssured.testGetUser.password;
import static io.restassured.RestAssured.given;

public class testPostTransferFunds {
    int fromAccountId = 14565;
    int toAccountId = 14898;
    String url = "https://parabank.parasoft.com/parabank/services/bank/transfer?fromAccountId=" + fromAccountId + "&toAccountId=" + toAccountId + "&amount=" + 1000;

    @Test
    @DisplayName("Descarga de fondos")
    @Tag("TestCase-Back")
    public void testOpenAccount() {
        JSONObject req = new JSONObject();

        given().auth().basic(userDemo, password).
                log().all().contentType(ContentType.JSON).
                body(req.toString()).
                when().
                post(url).
                then().
                statusCode(200).
                log().status()
                .log().body();

        /* response:
            HTTP/1.1 200 OK
            Successfully transferred $1000 from account #14565 to account #14898
        */
    }
}