package com.Pages;

import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageRegister extends BasePage {
    By registerBtn = By.linkText("Register");
    By inputName = By.id("customer.firstName");
    By inputLastName = By.id("customer.lastName");
    By inputAddress = By.id("customer.address.street");
    By inputCity = By.id("customer.address.city");
    By inputState = By.id("customer.address.state");
    By inputZipCode = By.id("customer.address.zipCode");
    By inputPhone = By.id("customer.phoneNumber");
    By inputSSN = By.id("customer.ssn");
    By inputUsername = By.id("customer.username");
    By inputPassword = By.id("customer.password");
    By inputConfirmPassword = By.id("repeatedPassword");
    By btnSubmit = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    By resultSuccess = By.xpath("//*[@id=\"rightPanel\"]/p");

    public PageRegister (WebDriver driver) { }

    public void clickRegisterBtn() throws InterruptedException {
        click(registerBtn);
        waitForUrlToContain(3, "https://parabank.parasoft.com/parabank/register.htm");
    }

    public void completeFormAndRegister(String name, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password) throws InterruptedException {
        write(name, inputName);
        write(lastName, inputLastName);
        write(address, inputAddress);
        write(city, inputCity);
        write(state, inputState);
        write(zipCode, inputZipCode);
        write(phone, inputPhone);
        write(ssn, inputSSN);
        write(username, inputUsername);
        write(password, inputPassword);
        write(password, inputConfirmPassword);

        click(btnSubmit);

        waitForTextToBePresent(5, resultSuccess, "Your account was created successfully. You are now logged in.");
    }

}
