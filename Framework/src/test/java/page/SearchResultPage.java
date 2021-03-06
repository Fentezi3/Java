package page;

import org.openqa.selenium.By;
import wait.WaitService;

public class SearchResultPage extends AbstractPage {
    private static final String RESULT_XPATH = "//div[@class='gsc-thumbnail-inside']" +
            "//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']";

    public SearchResultPage() {
        super();
    }

    public PricingCalculatorBlock selectCalculatorSite() {
        WaitService.waitForPresenceOfElementByXpath(driver,RESULT_XPATH);
        driver.findElement(By.xpath(RESULT_XPATH)).click();
        return new PricingCalculatorBlock();
    }
}
