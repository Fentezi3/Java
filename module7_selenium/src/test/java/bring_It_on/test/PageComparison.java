package bring_It_on.test;

import bring_It_on.pages.PastebinResultPage;
import bring_It_on.pages.PastebinStartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageComparison {


    public static final String CODE_TEXT = "git config --global user.name New Sheriff in Town\n" +
            "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
            "git push origin master --force";

    public static final String BASH_SYNTAX_HIGHLIGHTING = "Bash";
    public static final String PASTE_NAME = "how to gain dominance among developers";
    public static final String ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING = "//div[@class='form-group field-postform-format']//span[@class='select2-selection__arrow']";
    public static final String ARROW_XPATH_FOR_EXPIRATION = "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']";
    public static final String TEN_MIN_OPT_XPATH = "//li[text()='10 Minutes']";
    public static final String PASTE_NAME_ID = "postform-name";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testEqualsResultTitleToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(CODE_TEXT)
                .checkBashSyntax(ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING, BASH_SYNTAX_HIGHLIGHTING)
                .checkExpiration(ARROW_XPATH_FOR_EXPIRATION, TEN_MIN_OPT_XPATH)
                .enterPasteName(PASTE_NAME_ID, PASTE_NAME)
                .createPasteFile();
        resultPage.resultTitle();
        Assert.assertEquals(resultPage.titleString, PASTE_NAME, "Title not equals");
    }

    @Test
    public void testEqualsResultSyntaxToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(CODE_TEXT)
                .checkBashSyntax(ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING, BASH_SYNTAX_HIGHLIGHTING)
                .checkExpiration(ARROW_XPATH_FOR_EXPIRATION, TEN_MIN_OPT_XPATH)
                .enterPasteName(PASTE_NAME_ID, PASTE_NAME)
                .createPasteFile();
        resultPage.bashSyntax();
        Assert.assertEquals(resultPage.bashString, BASH_SYNTAX_HIGHLIGHTING);
    }

    @Test
    public void testEqualsResultCodeToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(CODE_TEXT)
                .checkBashSyntax(ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING, BASH_SYNTAX_HIGHLIGHTING)
                .checkExpiration(ARROW_XPATH_FOR_EXPIRATION, TEN_MIN_OPT_XPATH)
                .enterPasteName(PASTE_NAME_ID, PASTE_NAME)
                .createPasteFile();
        resultPage.codeIsCorrect();
        Assert.assertEquals(resultPage.codeString, CODE_TEXT);
    }

    @AfterMethod(alwaysRun = true)
    public void driverClose() {
        driver.quit();
        driver = null;
    }
}
