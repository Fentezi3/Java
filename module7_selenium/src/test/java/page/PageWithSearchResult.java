package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageWithSearchResult extends AbstractPage{ //TODO
    private WebDriver driver;

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public PageWithSearchResult(WebDriver driver) {
        super(driver);
    }

    public PricingCalculator findCalculatorSite() {
        List<WebElement> resultList = driver.findElements(By.xpath("//div[contains(@class,'gsc-webResult']"));
        WebElement firstResult = resultList.get(0);
        firstResult.click();
        return new PricingCalculator(driver);
    }
}
