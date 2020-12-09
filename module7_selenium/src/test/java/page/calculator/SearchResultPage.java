package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

public class SearchResultPage extends AbstractPage {
    private static final String RESULT_XPATH = "//div[@class='gsc-thumbnail-inside']" +
            "//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage selectCalculatorSite() {
        WebElement result = driver.findElement(By.xpath(RESULT_XPATH));
        result.click();
        return new PricingCalculatorPage(driver);
    }
}
