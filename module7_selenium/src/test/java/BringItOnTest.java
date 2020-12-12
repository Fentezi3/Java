import org.testng.Assert;
import org.testng.annotations.Test;
import page.pastebin.PastebinResultPage;
import page.pastebin.PastebinStartPage;

public class BringItOnTest extends AbstractTest {
    private static final String INPUT_CODE = "git config --global user.name New Sheriff in Town\n" +
            "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
            "git push origin master --force";
    private static final String PASTE_NAME = "how to gain dominance among developers";
    private static final String BASH = "Bash";

    @Test
    public void testEqualsResultTitle() {
        PastebinResultPage resultPage = createPastebin();
        Assert.assertEquals(resultPage.getPageTitle(), PASTE_NAME);
    }

    @Test
    public void testResultSyntax() {
        PastebinResultPage resultPage = createPastebin();
        Assert.assertEquals(resultPage.getCodeSyntax(), BASH);
    }

    @Test
    public void testEqualsResultCodeToOriginal() {
        PastebinResultPage resultPage = createPastebin();
        Assert.assertEquals(resultPage.getCodeFromPage(), INPUT_CODE);
    }

    private PastebinResultPage createPastebin() {
        return new PastebinStartPage(driver)
                .openPage()
                .inputCode(INPUT_CODE)
                .selectSyntaxHighlighting(BASH)
                .selectExpiration("10 Minutes")
                .enterPasteName(PASTE_NAME)
                .createPasteFile();
    }
}
