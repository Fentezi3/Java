import org.testng.Assert;
import org.testng.annotations.Test;
import page.PastebinResultPage;
import page.PastebinStartPage;

public class BringItOnTestMain extends AbstractTest {
    private static final String INPUT_CODE = "git config --global user.name New Sheriff in Town\n" +
            "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
            "git push origin master --force";
    private static final String PAGE_TITLE = "how to gain dominance among developers";
    private static final String BASH_SYNTAX_HIGHLIGHTING = "Bash";

    @Test
    public void testEqualsResultTitle() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(INPUT_CODE)
                .selectSyntaxHighlighting(BASH_SYNTAX_HIGHLIGHTING)
                .selectExpiration("10 Minutes")
                .enterPasteName(PAGE_TITLE)
                .createPasteFile();
        Assert.assertEquals(resultPage.getPageTitle(), PAGE_TITLE);
    }

    @Test
    public void testResultSyntax() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(INPUT_CODE)
                .selectSyntaxHighlighting(BASH_SYNTAX_HIGHLIGHTING)
                .selectExpiration("10 Minutes")
                .enterPasteName(PAGE_TITLE)
                .createPasteFile();
        Assert.assertEquals(resultPage.getCodeSyntax(BASH_SYNTAX_HIGHLIGHTING), BASH_SYNTAX_HIGHLIGHTING);
    }

    @Test
    public void testEqualsResultCodeToOriginal() {
        PastebinResultPage resultPage = new PastebinStartPage(driver)
                .openPage()
                .inputCode(INPUT_CODE)
                .selectSyntaxHighlighting(BASH_SYNTAX_HIGHLIGHTING)
                .selectExpiration("10 Minutes")
                .enterPasteName(PAGE_TITLE)
                .createPasteFile();
        Assert.assertEquals(resultPage.getCodeFromPage(), INPUT_CODE);
    }
}
