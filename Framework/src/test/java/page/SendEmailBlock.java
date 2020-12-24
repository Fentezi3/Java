package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wait.WaitService;

public class SendEmailBlock extends AbstractGooglePage {
    private static final String EMAIL_FIELD_XPATH = "//md-input-container[./label[contains(text(),'Email')]]" +
            "//input[@name='description']";
    private static final String SEND_EMAIL_BUTTON_XPATH = "//button[@aria-label='Send Email']";

    protected SendEmailBlock() {
        super();
    }

    public SendEmailBlock sendEmail(String copyEmail) {
        switchToFrame();
        WaitService.waitForElementToBeClickableByXpath(driver, EMAIL_FIELD_XPATH);
        WebElement emailField = driver.findElement(By.xpath(EMAIL_FIELD_XPATH));
        emailField.click();
        emailField.sendKeys(copyEmail);
        WaitService.waitForElementToBeClickableByXpath(driver, SEND_EMAIL_BUTTON_XPATH);
        driver.findElement(By.xpath(SEND_EMAIL_BUTTON_XPATH)).click();
        return this;
    }
}
