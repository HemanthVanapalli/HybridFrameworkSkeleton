package com.testCases;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {


    @Test
    public void loginTest() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(properties.getProperty("username"));
        loginPage.setPassword(properties.getProperty("password"));
        loginPage.clickLoginBtn();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
        } else {
            captureScreenshot(driver, "Login Test");
            Assert.assertTrue(false,"Failed to match title");
        }
    }
}
