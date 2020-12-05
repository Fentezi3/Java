package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

public class PageWithSearchResult extends AbstractPage {
    private static final String XPATH = "//div[@class='gsc-thumbnail-inside']" +
            "//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']";

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public PageWithSearchResult(WebDriver driver) {
        super(driver);
    }

    public PricingCalculator findCalculatorSite() {
        WebElement result = driver.findElement(By.xpath(XPATH));
        result.click();
        return new PricingCalculator(driver);
    }
}
