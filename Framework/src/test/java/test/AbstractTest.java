package test;

import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

import java.util.ArrayList;

public abstract class AbstractTest {
    protected WebDriver driver;

    @BeforeMethod()
    protected void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void driverClose() {
        DriverSingleton.closeDriver();
    }
}
