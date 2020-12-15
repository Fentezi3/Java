package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;
import wait.WaitService;

import java.util.List;

public class EmailPage extends AbstractPage {
    private static final String EMAIL_URL = "https://10minutemail.com/";
    private static final String MESSAGE_XPATH = "//div[@class='message_top']";
    private static final String EMAIL_ID = "mail_address";
    private static final String FIELD_LIST_XPATH = "//td//h3";

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public void openEmailPage() {
        driver.get(EMAIL_URL);
    }

    public String copyEmail() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> {
            return d.findElement(By.id(EMAIL_ID)).getAttribute("value").length() != 0;
        });
        WebElement emailAddress = driver.findElement(By.id(EMAIL_ID));
        emailAddress.click();
        return emailAddress.getAttribute("value");
    }

    public String getMonthlyCostFromMail() {
        WaitService.waitForElementToBeClickableByXpath(driver, MESSAGE_XPATH);
        WebElement message = driver.findElement(By.xpath(MESSAGE_XPATH));
        message.click();
        List<WebElement> emailWithCalculation = driver.findElements(By.xpath(FIELD_LIST_XPATH));
        WebElement monthlyCost = emailWithCalculation.get(1);
        return monthlyCost.getText();
    }
}
