package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinStartPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING =
            "//div[@class='form-group field-postform-format']//span[@class='select2-selection__arrow']";
    private static final String ARROW_XPATH_FOR_EXPIRATION =
            "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']";
    private static final String ID_INPUT_CODE = "postform-text";
    private static final String XPATH_SYNTAX_SEARCH = "//*[@type='search']";
    private static final String CHOOSE_ENTERED_SYNTAX =
            "//*[@id='select2-postform-format-results']";
    private static final String PASTE_NAME_ID = "postform-name";
    private static final String CREATE_BUTTON = "//button [text()='Create New Paste']";
    private static final String EXPIRATION = "//li[text()='%s']";
    private WebDriver driver;

    public PastebinStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public PastebinStartPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinStartPage inputCode(String inputCode) {
        WebElement searchInput = driver.findElement(By.id(ID_INPUT_CODE));
        searchInput.sendKeys(inputCode);
        return this;
    }

    public PastebinStartPage selectSyntaxHighlighting(String bashSyntax) {
        WebElement chooseSyntaxBox = driver.findElement(By.xpath(ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING));
        chooseSyntaxBox.click();
        WebElement enterSyntax = driver.findElement(By.xpath(XPATH_SYNTAX_SEARCH));
        enterSyntax.click();
        enterSyntax.sendKeys(bashSyntax);
        WebElement chooseSyntax = driver.findElement(By.xpath(CHOOSE_ENTERED_SYNTAX));
        chooseSyntax.click();
        return this;
    }

    public PastebinStartPage selectExpiration(String expiration) {
        String option = String.format(EXPIRATION, expiration);
        WebElement chooseExpiration = driver.findElement(By.xpath(ARROW_XPATH_FOR_EXPIRATION));
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
        WebElement createPaste = driver.findElement(By.xpath(CREATE_BUTTON));
        createPaste.click();
        return new PastebinResultPage(driver);
    }
}
