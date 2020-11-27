import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinStartPage;

public class ICanWinTestMain {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Test for task 'I can win'")
    public void createPageWithText() {
        new PastebinStartPage(driver)
                .openPage()
                .inputCode()
                .checkExpiration()
                .enterPasteName()
                .createPasteFile();
        driver.quit();
    }
}
