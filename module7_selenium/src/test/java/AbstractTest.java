import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    protected WebDriver driver;

    @BeforeClass
    protected static void setupChrome() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    protected void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    protected void driverClose() {
        driver.quit();
    }

    protected void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    protected void switchToTab(int tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabIndex));
    }
}
