package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

public abstract class AbstractGooglePage extends AbstractPage {
    protected static final String DIV_WITH_TEXT = "//div[contains(text(),'%s')]";
    private static final String I_FRAME_XPATH = "//article[@id='cloud-site']//devsite-iframe//iframe";
    private static final String MY_FRAME_XPATH = "//iframe[@id='myFrame']";

    protected AbstractGooglePage() {
        super();
    }

    protected void switchToFrame() {
        WebElement iFrame = driver.findElement(By.xpath(I_FRAME_XPATH));
        driver.switchTo().frame(iFrame);
        WebElement myFrame = driver.findElement(By.xpath(MY_FRAME_XPATH));
        driver.switchTo().frame(myFrame);
    }
}
