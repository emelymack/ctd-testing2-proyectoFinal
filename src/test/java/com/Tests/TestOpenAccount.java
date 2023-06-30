package com.Tests;

import com.Base.BasePage;
import com.Pages.PageOpenAccount;
import com.Reports.Reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.Tests.TestRegister.password;
import static com.Tests.TestRegister.username;

public class TestOpenAccount {
    private WebDriver driver;
    PageOpenAccount pageOpenAccount;
    By resultSuccess = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");
    public ExtentReports report;
    public ExtentTest test;

    @BeforeEach
    public void setUp() {
        pageOpenAccount = new PageOpenAccount(driver);
        driver = pageOpenAccount.chromeDriverConnection();
        driver.manage().window().maximize();
        pageOpenAccount.goToLink("https://parabank.parasoft.com/parabank/index.htm");
        pageOpenAccount.login(username, password);
        report = Reports.getInstance();
    }

    @AfterEach
    public void tearDown() {
        report.flush();
        driver.quit();
    }

    @Test
    @DisplayName("2- Apertura de nueva cuenta")
    @Tag("TestCase-Front")
    public void testOpenAccount() throws InterruptedException {
        test = report.startTest("Apertura de nueva cuenta");
        test.log(LogStatus.INFO, "Inicia test");
        pageOpenAccount.openAccount();

        BasePage.compareResultContainsExpected(pageOpenAccount.getText(resultSuccess), "Congratulations, your account is now open.");
        test.log(LogStatus.PASS, "Cuenta abierta exitosamente");
    }
}
