package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AbstractPage;

public class PricingResultPage extends AbstractPage {
    private static final String XPATH_REF = "//div[contains(text(),'%s')]";

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public PricingResultPage(WebDriver driver) {
        super(driver);
    }

    public String resultString(String string) {
        String xpath = String.format(XPATH_REF, string);
        return driver.findElement(By.xpath(xpath)).getText();
    }
}
