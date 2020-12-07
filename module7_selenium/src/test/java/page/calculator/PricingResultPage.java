package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AbstractPage;

import static page.calculator.PricingCalculator.XPATH_REFERENCE;

public class PricingResultPage extends AbstractPage {
    private static final String XPATH = XPATH_REFERENCE;
    private static final String COST_XPATH = "//h2[@class='md-title']//b";
    public enum FieldName {
        VM_CLASS("VM class: "),
        INSTANCE_TYPE("Instance type: "),
        REGION("Region: "),
        LOCAL_SSD("Total available local SSD space "),
        COMMITMENT_TERM("Commitment term: "),
        COST("Total Estimated Cost: ");

        private final String name;

        FieldName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public PricingResultPage(WebDriver driver) {
        super(driver);
    }

    public String getItemFieldValue(String string) {
        String xpath = String.format(XPATH, string);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String getCostFieldValue() {
        return driver.findElement(By.xpath(COST_XPATH)).getText();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
