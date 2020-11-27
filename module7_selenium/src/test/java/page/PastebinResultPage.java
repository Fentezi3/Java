package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinResultPage {
    private static final String SYNTAX_SELECTOR = "//*[text()='Bash']";
    public static final String TITLE_SELECTOR = "//h1";
    private WebDriver driver;

    public PastebinResultPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Find title page
     *
     * @return String title.
     */
    public String getPageTitle() {
        return driver.findElement(By.xpath(TITLE_SELECTOR)).getText();
    }

    /**
     * Find code syntax.
     *
     * @return String code syntax.
     */
    public String getCodeSyntax() {
        return driver.findElement(By.xpath(SYNTAX_SELECTOR)).getAttribute("innerText");
    }

    /**
     * Find code, that we entered earlie.
     *
     * @return String code.
     */
    public String getCodeFromPage() {
        return driver.findElement(By.className("textarea")).getAttribute("value");
    }
}
