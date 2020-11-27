import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinResultPage;
import page.PastebinStartPage;

import static page.PastebinResultPage.TITLE_SELECTOR;
import static page.PastebinStartPage.*;

public class BringItOnTestMain {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testEqualsResultTitleToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode()
                .checkBashSyntax()
                .checkExpiration()
                .enterPasteName()
                .createPasteFile();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TITLE_SELECTOR)));
        Assert.assertEquals(resultPage.getPageTitle(), PASTE_NAME);
    }

    @Test
    public void testEqualsResultSyntaxToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode()
                .checkBashSyntax()
                .checkExpiration()
                .enterPasteName()
                .createPasteFile();
        Assert.assertEquals(resultPage.getCodeSyntax(), BASH_SYNTAX_HIGHLIGHTING);
    }

    @Test
    public void testEqualsResultCodeToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode()
                .checkBashSyntax()
                .checkExpiration()
                .enterPasteName()
                .createPasteFile();
        Assert.assertEquals(resultPage.getCodeFromPage(), CODE_TEXT);
    }

    @AfterMethod(alwaysRun = true)
    public void driverClose() {
        driver.quit();
        driver = null;
    }
}
