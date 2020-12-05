package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

public class GoogleCloudStartPage extends AbstractPage {
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/ ";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage() {
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    public PageWithSearchResult findInfoOnTheSite() {
        WebElement searchButton = driver.findElement(By.name("q"));
        searchButton.click();
        searchButton.sendKeys(SEARCH_QUERY);
        searchButton.sendKeys(Keys.ENTER);
        return new PageWithSearchResult(driver);
    }
}
