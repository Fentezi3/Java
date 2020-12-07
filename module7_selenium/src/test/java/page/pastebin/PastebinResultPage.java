package page.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitService;

public class PastebinResultPage {
    private static final String SYNTAX_SELECTOR = "//*[text()='%s']";
    private static final String TITLE_SELECTOR = "//h1";
    private static final String CLASS_NAME_CODE = "textarea";
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
        WaitService.waitForPresenceOfElementByXpath(driver, TITLE_SELECTOR);
        return driver.findElement(By.xpath(TITLE_SELECTOR)).getText();
    }

    /**
     * Find code syntax.
     *
     * @param SyntaxHighlighting language for comparison.
     * @return String code syntax.
     */
    public String getCodeSyntax(String SyntaxHighlighting) {
        String syntaxFormat = String.format(SYNTAX_SELECTOR, SyntaxHighlighting);
        WaitService.waitForPresenceOfElementByXpath(driver, syntaxFormat);
        return driver.findElement(By.xpath(syntaxFormat)).getAttribute("innerText");
    }

    /**
     * Find code, that we entered earlie.
     *
     * @return String code.
     */
    public String getCodeFromPage() {
        WaitService.waitForPresenceOfElementByClassName(driver, CLASS_NAME_CODE);
        return driver.findElement(By.className(CLASS_NAME_CODE)).getAttribute("value");
    }
}
