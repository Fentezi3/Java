package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudStartPage extends AbstractPage{ //TODO
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/ ";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    protected GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage(){
        driver.get(GOOGLE_CLOUD_URL);
        return this;
    }

    @FindBy(name ="q")
    WebElement searchButton;

    public PageWithSearchResult findInfoOnTheSite() {
        searchButton.click();
        searchButton.sendKeys(SEARCH_QUERY);
        searchButton.click();
        return new PageWithSearchResult(driver);
    }

}
