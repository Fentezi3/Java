import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinStartPage;

import java.util.concurrent.TimeUnit;

public class ICanWinTestMain {
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
    public void createPageWithText() {
        new PastebinStartPage(driver)
                .openPage()
                .inputCode("git config --global user.name New Sheriff in Town\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
                        "git push origin master --force")
                .checkExpiration()
                .enterPasteName("how to gain dominance among developers")
                .createPasteFile();
        driver.quit();
    }
}
