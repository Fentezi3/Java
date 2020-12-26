package page;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    
    protected AbstractPage() {
        driver = DriverSingleton.getDriver();
    }
}
