package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    WebDriver localdriver;

    public LoginPage(WebDriver driver) {
        localdriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "uid")
    @CacheLookup
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement loginBtn;


    public void setUsername(String text) {
        username.sendKeys(text);
        log.info("Entered Username");
    }

    public void setPassword(String text) {
        password.sendKeys(text);
        log.info("Entered password");
    }

    public void clickLoginBtn() {
        loginBtn.click();
        log.info("Clicked on login button");
    }
}
