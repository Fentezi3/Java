package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import test.AbstractTest;

import java.util.ArrayList;

public class TabUtils extends AbstractTest {
    //private static WebDriver driver;

    public void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    public void switchToTab(int tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabIndex));
    }
}
