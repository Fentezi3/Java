package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import waits.CustomConditions;

import java.util.List;

public class SeleniumHQHomePage {
    driver.get("https://rutracker.net/forum/index.php");
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());

    WebElement searchInput = waitForElementLocateBy(driver, By.name("nm"));
        searchInput.sendKeys("selenium java");

    List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='поиск']"));
        searchBtn.get(0).click();
}
