package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wait.WaitMethod;

public class PastebinResultPage {
    private static final String SYNTAX_SELECTOR = "//*[text()='Bash']";
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
        WaitMethod.createWaitWithXpath(driver,TITLE_SELECTOR);
        return driver.findElement(By.xpath(TITLE_SELECTOR)).getText();
    }

    /**
     * Find code syntax.
     *
     * @return String code syntax.
     */
    public String getCodeSyntax() {
        WaitMethod.createWaitWithXpath(driver, SYNTAX_SELECTOR);
        return driver.findElement(By.xpath(SYNTAX_SELECTOR)).getAttribute("innerText");
    }

    /**
     * Find code, that we entered earlie.
     *
     * @return String code.
     */
    public String getCodeFromPage() {
        WaitMethod.createWaitWithClassName(driver, CLASS_NAME_CODE);
        return driver.findElement(By.className(CLASS_NAME_CODE)).getAttribute("value");
    }
}
