package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageOpenAccount extends BasePage {
    By btnOpenAccount = By.linkText("Open New Account");
    By btnSubmit = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div/input");
    By dropdownAccountType = By.id("type");
    By dropdownFromAccountId = By.id("fromAccountId");
    By resultSuccess = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");

    public PageOpenAccount (WebDriver driver) { }

    public void clickOpenAccountBtn() throws InterruptedException {
        click(btnOpenAccount);
        waitForUrlToBe(3, "https://parabank.parasoft.com/parabank/openaccount.htm");
    }

    public void openAccount() throws InterruptedException {
        clickOpenAccountBtn();

        Thread.sleep(500);
        Select dropdown1 = new Select(driver.findElement(dropdownAccountType));
        Select dropdown2 = new Select(driver.findElement(dropdownFromAccountId));

        dropdown1.selectByValue("1");
        dropdown2.selectByIndex(0);

        click(btnSubmit);

        waitForTextToBePresent(5, resultSuccess, "Congratulations, your account is now open.");
    }
}