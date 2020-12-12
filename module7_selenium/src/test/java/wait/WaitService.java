package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitService {
    public static void waitForPresenceOfElementByXpath(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void waitForPresenceOfElementByClassName(WebDriver driver, String className) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }

    public static void waitForElementToBeClickableByXpath(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}
