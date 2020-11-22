package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import waits.CustomConditions;

import java.util.List;

public class WebDriverSeleniumHQTest {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test (description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsAreNotEmpty () {

        driver.get("https://rutracker.net/forum/index.php");
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());

        WebElement searchInput = waitForElementLocateBy(driver, By.name("nm"));
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='поиск']"));
        searchBtn.get(0).click();
        Assert.assertTrue(searchBtn.size() > 0, "Button search not find");

    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown (){
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocateBy (WebDriver driver, By by) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
