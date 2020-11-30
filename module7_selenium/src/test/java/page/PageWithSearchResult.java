package page;

import org.openqa.selenium.WebDriver;

public class PageWithSearchResult { //TODO
    private WebDriver driver;
    public PageWithSearchResult(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudPlatformPricingCalculator findCalculatorSite() {

        return new GoogleCloudPlatformPricingCalculator(driver);
    }
}
