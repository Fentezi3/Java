package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitService;

public class PricingResultBlock extends AbstractGooglePage {
    private static final String FIELD_XPATH = DIV_WITH_TEXT;
    private static final String COST_XPATH = "//h2[@class='md-title']//b";
    private static final String EMAIL_ESTIMATE_BUTTON_XPATH = "//button[@aria-label='Email Estimate']";

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

    public PricingResultBlock(WebDriver driver) {
        super(driver);
    }

    public String getItemFieldValue(String string) {
        return driver.findElement(By.xpath(String.format(FIELD_XPATH, string))).getText();
    }

    public String getCostFieldValue() {
        return driver.findElement(By.xpath(COST_XPATH)).getText();
    }

    public SendEmailBlock selectEmailEstimate() {
        driver.findElement(By.xpath(EMAIL_ESTIMATE_BUTTON_XPATH)).click();
        return new SendEmailBlock(driver);
    }
}
