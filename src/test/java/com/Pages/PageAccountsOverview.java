package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageAccountsOverview extends BasePage {
    By btnAccountsOverview = By.linkText("Accounts Overview");
    By account = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    By titleDetails = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    By dropdownActivityPeriod = By.id("month");
    By dropdownType = By.id("transactionType");
    By btnSubmitAccountActivity = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");
    By resultSuccess = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");

    public PageAccountsOverview (WebDriver driver) { }

    public void viewAccountsOverview() {
        click(btnAccountsOverview);
        waitForUrlToBe(3, "https://parabank.parasoft.com/parabank/overview.htm");
        waitForTextToBePresent(5, resultSuccess, "*Balance includes deposits that may be subject to holds");
    }

    public void viewMonthOverview() {
        waitForElementToBePresent(5, account);
        click(account);

        waitForUrlToContain(3, "https://parabank.parasoft.com/parabank/activity.htm?id=");
        waitForTextToBePresent(5, titleDetails, "Account Details");
    }

    public void viewAccountActivity() throws InterruptedException {
        Thread.sleep(500);
        Select dropdown1 = new Select(driver.findElement(dropdownActivityPeriod));
        Select dropdown2 = new Select(driver.findElement(dropdownType));

        dropdown1.selectByValue("All");
        dropdown2.selectByValue("All");

        click(btnSubmitAccountActivity);
    }
}















