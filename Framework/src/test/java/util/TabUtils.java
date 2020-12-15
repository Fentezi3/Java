package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabUtils {
    private static WebDriver driver;

    public static void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    public static void switchToTab(int tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabIndex));
    }
}
