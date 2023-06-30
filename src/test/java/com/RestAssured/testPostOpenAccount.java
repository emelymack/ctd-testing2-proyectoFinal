package com.RestAssured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static com.RestAssured.testGetAccountsOverview.customerId;
import static com.RestAssured.testGetUser.userDemo;
import static com.RestAssured.testGetUser.password;
import static io.restassured.RestAssured.given;

public class testPostOpenAccount {
    int fromAccountId = 13788;
    String url = "https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=" + customerId + "&newAccountType=1&fromAccountId=" + fromAccountId;

    @Test
    @DisplayName("Abrir nueva cuenta")
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
            {
                "id": 14676,
                "customerId": 12989,
                "type": "SAVINGS",
                "balance": 0
            }
         */
    }
}
