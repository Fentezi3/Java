import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinResultPage;
import page.PastebinStartPage;

import java.util.concurrent.TimeUnit;

public class BringItOnTestMain {
    private static final String INPUT_CODE = "git config --global user.name New Sheriff in Town\n" +
            "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
            "git push origin master --force";
    private static final String PAGE_TITLE = "how to gain dominance among developers";
    private static final String BASH_SYNTAX_HIGHLIGHTING = "Bash";
    private WebDriver driver;

    @BeforeClass
    public static void setupChrome(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testEqualsResultTitle() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(INPUT_CODE)
                .checkBashSyntax(BASH_SYNTAX_HIGHLIGHTING)
                .checkExpiration()
                .enterPasteName(PAGE_TITLE)
                .createPasteFile();
        Assert.assertEquals(resultPage.getPageTitle(), PAGE_TITLE);
    }

    @Test
    public void testResultSyntax() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(INPUT_CODE)
                .checkBashSyntax(BASH_SYNTAX_HIGHLIGHTING)
                .checkExpiration()
                .enterPasteName(PAGE_TITLE)
                .createPasteFile();
        Assert.assertEquals(resultPage.getCodeSyntax(), BASH_SYNTAX_HIGHLIGHTING);
    }

    @Test
    public void testEqualsResultCodeToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(INPUT_CODE)
                .checkBashSyntax(BASH_SYNTAX_HIGHLIGHTING)
                .checkExpiration()
                .enterPasteName(PAGE_TITLE)
                .createPasteFile();
        Assert.assertEquals(resultPage.getCodeFromPage(), INPUT_CODE);
    }

    @AfterMethod(alwaysRun = true)
    public void driverClose() {
        driver.quit();
        driver = null;
    }
}
