package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageTransferFunds extends BasePage {
    By btnTransferFunds = By.linkText("Transfer Funds");
    By title = By.className("title");
    By inputAmount = By.id("amount");
    By dropdownFromAccount = By.id("fromAccountId");
    By dropdownToAccount = By.id("toAccountId");
    By btnSubmit = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");
    By resultSuccess = By.className("title");

    public PageTransferFunds (WebDriver driver) { }

    public void clickTransferFundsBtn() throws InterruptedException {
        click(btnTransferFunds);
        waitForUrlToBe(3, "https://parabank.parasoft.com/parabank/transfer.htm");
        waitForTextToBePresent(3, title, "Transfer Funds");
    }

    public void transfer(String amount) throws InterruptedException {
        Thread.sleep(500);
        Select dropdown1 = new Select(driver.findElement(dropdownFromAccount));
        Select dropdown2 = new Select(driver.findElement(dropdownToAccount));
        write(amount, inputAmount);
        dropdown1.selectByIndex(0);
        dropdown2.selectByIndex(1);

        click(btnSubmit);

        waitForTextToBePresent(5, resultSuccess, "Transfer Complete!");
    }

}
