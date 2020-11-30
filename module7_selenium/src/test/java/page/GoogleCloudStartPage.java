package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudStartPage { //TODO
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/ ";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";
    private WebDriver driver;

    @FindBy(name ="q")
    WebElement searchButton;

    public GoogleCloudStartPage openSite(){
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    public PageWithSearchResult findInfoOnTheSite() {
        searchButton.click();
        searchButton.sendKeys(SEARCH_QUERY);
        searchButton.click();
        return new PageWithSearchResult(driver);
    }
}
