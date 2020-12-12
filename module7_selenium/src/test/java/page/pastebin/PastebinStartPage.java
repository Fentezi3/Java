package page.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

public class PastebinStartPage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String INPUT_CODE_ID = "postform-text";
    private static final String SYNTAX_HIGHLIGHTING_ARROW_XPATH =
            "//div[@class='form-group field-postform-format']//span[@class='select2-selection__arrow']";
    private static final String SYNTAX_SEARCH_XPATH = "//*[@type='search']";
    private static final String EXPIRATION_ARROW_XPATH =
            "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']";
    private static final String ENTERED_SYNTAX_XPATH =
            "//*[@id='select2-postform-format-results']";
    private static final String EXPIRATION_REFERENCE_XPATH_PATTERN = "//li[text()='%s']";
    private static final String PASTE_NAME_ID = "postform-name";
    private static final String CREATE_BUTTON_XPATH = "//button [text()='Create New Paste']";

    public PastebinStartPage(WebDriver driver) {
        super(driver);
    }

    public PastebinStartPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinStartPage inputCode(String inputCode) {
        driver.findElement(By.id(INPUT_CODE_ID)).sendKeys(inputCode);
        return this;
    }

    public PastebinStartPage selectSyntaxHighlighting(String bashSyntax) {
        driver.findElement(By.xpath(SYNTAX_HIGHLIGHTING_ARROW_XPATH)).click();
        WebElement enterSyntax = driver.findElement(By.xpath(SYNTAX_SEARCH_XPATH));
        enterSyntax.click();
        enterSyntax.sendKeys(bashSyntax);
        driver.findElement(By.xpath(ENTERED_SYNTAX_XPATH)).click();
        return this;
    }

    public PastebinStartPage selectExpiration(String expiration) {
        driver.findElement(By.xpath(EXPIRATION_ARROW_XPATH)).click();
        driver.findElement(By.xpath(String.format(EXPIRATION_REFERENCE_XPATH_PATTERN, expiration))).click();
        return this;
    }

    public PastebinStartPage enterPasteName(String pasteName) {
        driver.findElement(By.id(PASTE_NAME_ID)).sendKeys(pasteName);
        return this;
    }

    public PastebinResultPage createPasteFile() {
        driver.findElement(By.xpath(CREATE_BUTTON_XPATH)).click();
        return new PastebinResultPage(driver);
    }
}
