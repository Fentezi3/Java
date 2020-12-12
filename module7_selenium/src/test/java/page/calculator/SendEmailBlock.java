package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendEmailBlock extends AbstractGooglePage {
    private static final String EMAIL_FIELD_XPATH = "//md-input-container[./label[contains(text(),'Email')]]" +
            "//input[@name='description']";
    private static final String SEND_EMAIL_BUTTON_XPATH = "//button[@aria-label='Send Email']";

    protected SendEmailBlock(WebDriver driver) {
        super(driver);
    }

    public SendEmailBlock sendEmail(String copyEmail) {
        switchToFrame();
        WebElement emailField = driver.findElement(By.xpath(EMAIL_FIELD_XPATH));
        emailField.click();
        emailField.sendKeys(copyEmail);
        driver.findElement(By.xpath(SEND_EMAIL_BUTTON_XPATH)).click();
        return this;
    }
}
