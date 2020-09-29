package com.base;

import com.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.utilities.ReadConfig.readConfig;


public class BaseClass {

    public static Properties properties;
    public static WebDriver driver;
    public Logger log = LogManager.getLogger(this.getClass());

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        properties = readConfig("./Configuration/config.properties");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            log.info("Launched chrome browser");
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\" + "Drivers/firefoxdriver.exe");
            driver = new ChromeDriver();
            log.info("Launched firefox browser");
        }

        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("Driver quit");
    }

    public void captureScreenshot(WebDriver driver, String testcaseName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\" + "./Screenshots/" + testcaseName + ".png");
        FileUtils.copyFile(src, target);
    }

}
