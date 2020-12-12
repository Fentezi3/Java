import org.testng.annotations.Test;
import page.pastebin.PastebinStartPage;

public class ICanWinTest extends AbstractTest {

    @Test
    public void createPageWithText() {
        new PastebinStartPage(driver)
                .openPage()
                .inputCode("git config --global user.name New Sheriff in Town\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m Legacy code)\n" +
                        "git push origin master --force")
                .selectExpiration("10 Minutes")
                .enterPasteName("how to gain dominance among developers")
                .createPasteFile();
    }
}
