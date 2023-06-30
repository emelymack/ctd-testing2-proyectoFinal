package com.Tests;

import com.Base.BasePage;
import com.Pages.PageAccountsOverview;
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

public class TestAccountsOverview {
    private WebDriver driver;
    PageAccountsOverview pageAccountsOverview;
    PageOpenAccount pageOpenAccount;
    By titleDetails = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    By resultSuccess = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    public ExtentReports report;
    public ExtentTest test;

    @BeforeEach
    public void setUp() {
        pageAccountsOverview = new PageAccountsOverview(driver);
        pageOpenAccount = new PageOpenAccount(driver);
        driver = pageAccountsOverview.chromeDriverConnection();
        driver.manage().window().maximize();
        pageAccountsOverview.goToLink("https://parabank.parasoft.com/parabank/index.htm");
        pageAccountsOverview.login(username, password);
        report = Reports.getInstance();
    }

    @AfterEach
    public void tearDown() {
        report.flush();
        driver.quit();
    }

    @Test
    @DisplayName("3- Resumen de las cuentas")
    @Tag("TestCase-Front")
    @Order(1)
    public void viewAccountsOverview() throws InterruptedException {
        test = report.startTest("Ver resumen de las cuentas");
        test.log(LogStatus.INFO, "Inicia test");
        pageOpenAccount.openAccount();
        pageAccountsOverview.viewAccountsOverview();

        BasePage.compareResultContainsExpected(pageAccountsOverview.getText(resultSuccess), "*Balance includes deposits that may be subject to holds");
        test.log(LogStatus.PASS, "Visualización exitosa");
    }

    @Test
    @Order(2)
    @DisplayName("5- Actividad de la cuenta (cada mes)")
    @Tag("TestCase-Front")
    public void viewMonthlyAccountActivity() throws InterruptedException {
        test = report.startTest("Ver actividad de las cuentas (cada mes)");
        test.log(LogStatus.INFO, "Inicia test");
        pageAccountsOverview.viewAccountsOverview();

        pageAccountsOverview.viewMonthOverview();
        BasePage.compareResultContainsExpected(pageAccountsOverview.getText(titleDetails), "Account Details");
        test.log(LogStatus.PASS, "El título se ubica correctamente");

        pageAccountsOverview.viewAccountActivity();
        test.log(LogStatus.PASS, "Visualización exitosa");
    }
}
