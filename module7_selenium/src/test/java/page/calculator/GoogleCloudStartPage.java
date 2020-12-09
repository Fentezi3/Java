package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

public class GoogleCloudStartPage extends AbstractPage {
    private static final String SEARCH_BUTTON_NAME = "q";

    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage(String googleCloudUrl) {
        driver.get(googleCloudUrl);
        return this;
    }

    public SearchResultPage searchFor(String searchQuery) {
        WebElement searchButton = driver.findElement(By.name(SEARCH_BUTTON_NAME));
        searchButton.click();
        searchButton.sendKeys(searchQuery);
        searchButton.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
