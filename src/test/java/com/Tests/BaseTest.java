package com.Tests;

import com.Base.BasePage;

public class BaseTest {
    public static String username = "john";
    public static String password = "demo";
    BasePage basePage;

    public void loginUser() {
        basePage = new BasePage();
        basePage.login(username, password);
    }
}
