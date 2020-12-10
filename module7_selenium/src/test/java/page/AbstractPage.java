package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected static final String XPATH_PATTERN = "//div[contains(text(),'%s')]";
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
