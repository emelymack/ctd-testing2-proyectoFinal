package com.Tests;

import com.Base.BasePage;
import com.Pages.PageTransferFunds;
import com.Reports.Reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.Tests.TestRegister.password;
import static com.Tests.TestRegister.username;

public class TestTransferFunds {
    private WebDriver driver;
    PageTransferFunds pageTransferFunds;
    By title = By.className("title");
    By resultSuccess = By.className("title");
    public ExtentReports report;
    public ExtentTest test;

    @BeforeEach
    public void setUp() {
        pageTransferFunds = new PageTransferFunds(driver);
        driver = pageTransferFunds.chromeDriverConnection();
        driver.manage().window().maximize();
        pageTransferFunds.goToLink("https://parabank.parasoft.com/parabank/index.htm");
        pageTransferFunds.login(username, password);
        report = Reports.getInstance();
    }

    @AfterEach
    public void tearDown() {
        report.flush();
        driver.quit();
    }

    @Test
    @DisplayName("4- Transferir fondos")
    @Tag("TestCase-Front")
    public void transferFunds() throws InterruptedException {
        test = report.startTest("Transferir fondos");
        test.log(LogStatus.INFO, "Inicia test");
        pageTransferFunds.clickTransferFundsBtn();

        BasePage.compareResultContainsExpected(pageTransferFunds.getText(title), "Transfer Funds");
        test.log(LogStatus.PASS, "El título se ubica correctamente");

        pageTransferFunds.transfer("1000");
        BasePage.compareResultContainsExpected(pageTransferFunds.getText(resultSuccess), "Transfer Complete!");
        test.log(LogStatus.PASS, "Transferencia exitosa");
    }
}
