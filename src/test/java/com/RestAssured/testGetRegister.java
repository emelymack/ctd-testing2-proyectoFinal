package com.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class testGetRegister {
    String url = "https://parabank.parasoft.com/parabank/register.htm";
    Response res = RestAssured.get(url);

    @Test
    @DisplayName("Registro")
    @Tag("TestCase-Back")
    public void testRegister() {
        int statusCode = 200;
        int responseCode = res.getStatusCode();
        System.out.println(res.getHeader("content-type"));

        Assertions.assertEquals(statusCode, responseCode);
    }
}
