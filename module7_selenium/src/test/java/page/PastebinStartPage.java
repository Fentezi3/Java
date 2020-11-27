package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinStartPage {
    public static final String CODE_TEXT = "git config --global user.name New Sheriff in Town\n" +
            "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
            "git push origin master --force";
    public static final String BASH_SYNTAX_HIGHLIGHTING = "Bash";
    public static final String PASTE_NAME = "how to gain dominance among developers";
    public static final String ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING =
            "//div[@class='form-group field-postform-format']//span[@class='select2-selection__arrow']";
    public static final String ARROW_XPATH_FOR_EXPIRATION =
            "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']";
    public static final String TEN_MIN_OPT_XPATH = "//li[text()='10 Minutes']";
    public static final String PASTE_NAME_ID = "postform-name";
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String CREATE_BUTTON = "//button [text()='Create New Paste']";
    private static final String XPATH_SYNTAX_SEARCH = "//*[@type='search']";
    private static final String CHOOSE_BASH_SYNTAX =
            "//*[@class='select2-results__option select2-results__option--highlighted']";
    private static final String ID_INPUT_CODE = "postform-text";
    private WebDriver driver;

    public PastebinStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public PastebinStartPage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinStartPage inputCode() {
        WebElement searchInput = driver.findElement(By.id(ID_INPUT_CODE));
        searchInput.sendKeys(CODE_TEXT);
        return this;
    }

    public PastebinStartPage checkBashSyntax() {
        WebElement chooseSyntaxBox = driver.findElement(By.xpath(ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING));
        chooseSyntaxBox.click();
        WebElement enterSyntax = driver.findElement(By.xpath(XPATH_SYNTAX_SEARCH));
        enterSyntax.click();
        enterSyntax.sendKeys(BASH_SYNTAX_HIGHLIGHTING);
        WebElement chooseSyntax = driver.findElement(By.xpath(CHOOSE_BASH_SYNTAX));
        chooseSyntax.click();
        return this;
    }

    public PastebinStartPage checkExpiration() {
        WebElement chooseExpiration = driver.findElement(By.xpath(ARROW_XPATH_FOR_EXPIRATION));
        chooseExpiration.click();
        WebElement tenMinOption = driver.findElement(By.xpath(TEN_MIN_OPT_XPATH));
        tenMinOption.click();
        return this;
    }

    public PastebinStartPage enterPasteName() {
        WebElement pasteTitle = driver.findElement(By.id(PASTE_NAME_ID));
        pasteTitle.sendKeys(PASTE_NAME);
        return this;
    }

    public PastebinResultPage createPasteFile() {
        WebElement createPaste = driver.findElement(By.xpath(CREATE_BUTTON));
        createPaste.click();
        return new PastebinResultPage(driver);
    }
}
