package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethod {
    public static void createWaitWithXpath(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void createWaitWithClassName(WebDriver driver, String className) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
    }

    public static void createClickableWaitWithXpath(WebDriver driver, String xpath) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static void createClickableWaitWithID(WebDriver driver, String id) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }
}
