package i_can_win.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CanWinPageObject {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    public WebDriver driver;

    public CanWinPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public CanWinPageObject openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CanWinPageObject enterText(String text) {
        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys(text);
        return this;
    }

    public CanWinPageObject pasteExpiration(String arrowPath, String tenMinPath) {
        WebElement arrow = driver.findElement(By
                .xpath(arrowPath));
        arrow.click();
        WebElement tenMinOpt = driver.findElement(By.xpath(tenMinPath));
        tenMinOpt.click();
        return this;
    }

    public CanWinPageObject pasteName(String inputText) {
        WebElement searchPostFormName = driver.findElement(By.id("postform-name"));
        searchPostFormName.sendKeys(inputText);
        return this;
    }

    public CanWinPageObject create() {
        WebElement searchCreateButton = driver.findElement(By.xpath("//button [text()='Create New Paste']"));
        searchCreateButton.click();
        return this;
    }
}
