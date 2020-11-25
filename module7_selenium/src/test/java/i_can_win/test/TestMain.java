package i_can_win.test;

import i_can_win.page.CanWinPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMain {
    public static final String ARROW_XPATH = "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']";
    public static final String TEN_MIN_OPT_XPATH = "//li[text()='10 Minutes']";

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Test for task 'I can win'")
    public void createPageWithText() {
        CanWinPageObject page = new CanWinPageObject(driver)
                .openPage()
                .enterText("Hello from WebDriver")
                .pasteExpiration(ARROW_XPATH, TEN_MIN_OPT_XPATH)
                .pasteName("helloweb")
                .create();
        Assert.assertNotNull(page, "Test is fallen.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
