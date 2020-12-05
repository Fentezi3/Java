package page.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinStartPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String INPUT_CODE_ID = "postform-text";
    private static final String SYNTAX_HIGHLIGHTING_ARROW_XPATH =
            "//div[@class='form-group field-postform-format']//span[@class='select2-selection__arrow']";
    private static final String SYNTAX_SEARCH_XPATH = "//*[@type='search']";
    private static final String EXPIRATION_ARROW_XPATH =
            "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']";
    private static final String ENTERED_SYNTAX_XPATH =
            "//*[@id='select2-postform-format-results']";
    private static final String EXPIRATION_REFERENCE = "//li[text()='%s']";
    private static final String PASTE_NAME_ID = "postform-name";
    private static final String CREATE_BUTTON_XPATH = "//button [text()='Create New Paste']";
    private WebDriver driver;

    public PastebinStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public PastebinStartPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinStartPage inputCode(String inputCode) {
        WebElement searchInput = driver.findElement(By.id(INPUT_CODE_ID));
        searchInput.sendKeys(inputCode);
        return this;
    }

    public PastebinStartPage selectSyntaxHighlighting(String bashSyntax) {
        WebElement chooseSyntaxBox = driver.findElement(By.xpath(SYNTAX_HIGHLIGHTING_ARROW_XPATH));
        chooseSyntaxBox.click();
        WebElement enterSyntax = driver.findElement(By.xpath(SYNTAX_SEARCH_XPATH));
        enterSyntax.click();
        enterSyntax.sendKeys(bashSyntax);
        WebElement chooseSyntax = driver.findElement(By.xpath(ENTERED_SYNTAX_XPATH));
        chooseSyntax.click();
        return this;
    }

    public PastebinStartPage selectExpiration(String expiration) {
        String option = String.format(EXPIRATION_REFERENCE, expiration);
        WebElement chooseExpiration = driver.findElement(By.xpath(EXPIRATION_ARROW_XPATH));
        chooseExpiration.click();
        WebElement tenMinOption = driver.findElement(By.xpath(option));
        tenMinOption.click();
        return this;
    }

    public PastebinStartPage enterPasteName(String pasteName) {
        WebElement pasteTitle = driver.findElement(By.id(PASTE_NAME_ID));
        pasteTitle.sendKeys(pasteName);
        return this;
    }

    public PastebinResultPage createPasteFile() {
        WebElement createPaste = driver.findElement(By.xpath(CREATE_BUTTON_XPATH));
        createPaste.click();
        return new PastebinResultPage(driver);
    }
}
