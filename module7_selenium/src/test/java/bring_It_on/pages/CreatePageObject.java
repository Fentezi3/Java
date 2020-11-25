package bring_It_on.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePageObject {
    public static final String CODE_TEXT = "git config --global user.name New Sheriff in Town\n" +
            "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
            "git push origin master --force";

    public static final String BASH_SYNTAX_HIGHLIGHTING = "Bash";
    public static final String PASTE_NAME = "how to gain dominance among developers";
    public static final String ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING = "//div[@class='form-group field-postform-format']//span[@class='select2-selection__arrow']";
    public static final String ARROW_XPATH_FOR_EXPIRATION = "//div[@class='form-group field-postform-expiration']//span[@class='select2-selection__arrow']";
    public static final String TEN_MIN_OPT_XPATH = "//li[text()='10 Minutes']";
    public static final String PASTE_NAME_ID = "postform-name";

    public static PastebinResultPage createPageWithCode() {
        WebDriver driver = null;
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(CODE_TEXT)
                .checkBashSyntax(ARROW_XPATH_FOR_SYNTAX_HIGHLIGHTING, BASH_SYNTAX_HIGHLIGHTING)
                .checkExpiration(ARROW_XPATH_FOR_EXPIRATION, TEN_MIN_OPT_XPATH)
                .enterPasteName(PASTE_NAME_ID, PASTE_NAME)
                .createPasteFile();
        return resultPage;
    }
}
