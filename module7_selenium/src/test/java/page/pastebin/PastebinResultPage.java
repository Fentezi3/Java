package page.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AbstractPage;
import wait.WaitService;

public class PastebinResultPage extends AbstractPage {
    private static final String SYNTAX_SELECTOR_XPATH_PATTERN = "//*[text()='%s']";
    private static final String TITLE_XPATH = "//h1";
    private static final String CODE_CLASS_NAME = "textarea";

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Find title page
     *
     * @return String title.
     */
    public String getPageTitle() {
        WaitService.waitForPresenceOfElementByXpath(driver, TITLE_XPATH);
        return driver.findElement(By.xpath(TITLE_XPATH)).getText();
    }

    /**
     * Find code syntax.
     *
     * @param SyntaxHighlighting language for comparison.
     * @return String code syntax.
     */
    public String getCodeSyntax(String SyntaxHighlighting) {
        String syntaxFormat = String.format(SYNTAX_SELECTOR_XPATH_PATTERN, SyntaxHighlighting);
        WaitService.waitForPresenceOfElementByXpath(driver, syntaxFormat);
        return driver.findElement(By.xpath(syntaxFormat)).getAttribute("innerText");
    }

    /**
     * Find code, that we entered earlie.
     *
     * @return String code.
     */
    public String getCodeFromPage() {
        WaitService.waitForPresenceOfElementByClassName(driver, CODE_CLASS_NAME);
        return driver.findElement(By.className(CODE_CLASS_NAME)).getAttribute("value");
    }
}
