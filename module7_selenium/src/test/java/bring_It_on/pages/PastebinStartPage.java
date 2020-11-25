package bring_It_on.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinStartPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String CREATE_BUTTON = "//button [text()='Create New Paste']";
    private WebDriver driver;

    public PastebinStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public PastebinStartPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinStartPage inputCode(String text) {
        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys(text);
        return this;
    }

    public PastebinStartPage checkBashSyntax(String xpathForBox, String bashSyntax) {
        WebElement chooseSyntaxBox = driver.findElement(By.xpath(xpathForBox));
        chooseSyntaxBox.click();
        WebElement enterSyntax = driver.findElement(By.xpath("//*[@type='search']"));
        enterSyntax.click();
        enterSyntax.sendKeys(bashSyntax);
        WebElement chooseSyntax = driver.findElement(By.xpath("//*[@class='select2-results__option select2-results__option--highlighted']"));
        chooseSyntax.click();
        return this;
    }

    public PastebinStartPage checkExpiration(String arrowXpath, String tenMinOpt) {
        WebElement chooseExpiration = driver.findElement(By.xpath(arrowXpath));
        chooseExpiration.click();
        WebElement tenMinOption = driver.findElement(By.xpath(tenMinOpt));
        tenMinOption.click();
        return this;
    }

    public PastebinStartPage enterPasteName(String pasteNameId, String pasteName) {
        WebElement pasteTitle = driver.findElement(By.id(pasteNameId));
        pasteTitle.sendKeys(pasteName);
        return this;
    }

    public PastebinResultPage createPasteFile() {
        WebElement createPaste = driver.findElement(By.xpath(CREATE_BUTTON));
        createPaste.click();
        return new PastebinResultPage(driver);
    }
}
