package com.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.Tests.TestRegister.password;
import static com.Tests.TestRegister.username;

public class testGetUser {
    String url = "https://parabank.parasoft.com/parabank/services/bank/login/" + username + "/" + password;
    Response res = RestAssured.get(url);

    @Test
    public void testLogin() {
        int statusCode = 200;
        int responseCode = res.getStatusCode();
        System.out.println(res.getBody().asString());

        Assertions.assertEquals(statusCode, responseCode);

        /*
         <?xml version="1.0" encoding="UTF-8"standalone="yes"?>
            <customer>
                <id>14876</id>
                <firstName>Jennifer</firstName>
                <lastName>Lawrence</lastName>
                <address>
                    <street>707 State</street>
                    <city>New York</city>
                    <state>NY</state>
                    <zipCode>12345</zipCode>
                </address>
                <phoneNumber>1-521-456-4576</phoneNumber>
                <ssn>56545</ssn>
            </customer>
        * */
    }
}
