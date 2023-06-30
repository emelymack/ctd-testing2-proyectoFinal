package com.RestAssured;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class testGetAccountsOverview {
    public static int customerId = 12212;
    String url = "https://parabank.parasoft.com/parabank/services/bank/customers/"+customerId+"/accounts";

    @Test
    @DisplayName("Resumen de las cuentas")
    @Tag("TestCase-Back")
    public void testGetAccountsOverview() {
        given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .log().status()
                .log().body();
    }
    /* response:
    * <accounts>
        <account>
          <id>15009</id>
          <customerId>12212</customerId>
          <type>CHECKING</type>
          <balance>999000.00</balance>
        </account>
        <account>
          <id>15231</id>
          <customerId>12212</customerId>
          <type>SAVINGS</type>
          <balance>1000.00</balance>
        </account>
      </accounts>
    * */
}
