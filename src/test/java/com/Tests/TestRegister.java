package com.Tests;

import static org.junit.jupiter.api.Assertions.*;

import com.Base.BasePage;
import com.Pages.PageRegister;
import com.Reports.Reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRegister {
	private static WebDriver driver;
	PageRegister pageRegister;
	public String username = "testingUser" + (int)(Math.random()*1000+1);
	public String password = "123456";
	By resultSuccess = By.xpath("//*[@id=\"rightPanel\"]/p");
	public ExtentReports report;
	public ExtentTest test;

	@BeforeEach
	public void setUp() {
		pageRegister = new PageRegister(driver);
		driver = pageRegister.chromeDriverConnection();
		driver.manage().window().maximize();
		pageRegister.goToLink("https://parabank.parasoft.com/parabank/index.htm");
		report = Reports.getInstance();
	}

	@AfterEach
	public void tearDown() {
		report.flush();
		driver.quit();
	}

	@Test
	@DisplayName("1- Proceso de registro")
	@Tag("TestCase-Front")
	public void testRegister() throws InterruptedException {
		test = report.startTest("Proceso de registro");
		test.log(LogStatus.INFO, "Inicia test");
		pageRegister.clickRegisterBtn();
		pageRegister.completeFormAndRegister("Jennifer", "Lawrence","707 State", "New York", "NY","12345", "1-521-456-4576","56545",username, password);

		BasePage.compareResultContainsExpected(pageRegister.getText(resultSuccess), "Your account was created successfully. You are now logged in.");
		test.log(LogStatus.PASS, "Registro exitoso");
	}

}
