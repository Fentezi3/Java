import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.calculator.*;

import java.util.ArrayList;

public class HardcoreTest extends AbstractTest {
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/ ";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @Test
    public void testResultInEmailEqualsManualResult() {
        PricingResultBlock resultPage = createResultBlock();

        String costInResultPage = resultPage.getCostFieldValue();
        SendEmailBlock sendEmail = resultPage.selectEmailEstimate();
        createNewTab();
        switchToTab(1);

        EmailPage emailPage = new EmailPage(driver);
        emailPage.openEmailPage();
        String email = emailPage.copyEmail();
        switchToTab(0);

        sendEmail.sendEmail(email);
        switchToTab(1);

        String costInEmail = emailPage.getMonthlyCostFromMail();
        Assert.assertTrue(costInResultPage.contains(costInEmail));
    }

    public void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    private void switchToTab(int tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabIndex));
    }

    private PricingResultBlock createResultBlock() {
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        SearchResultPage searchResultPage = googleCloudStartPage
                .openPage(GOOGLE_CLOUD_URL)
                .searchFor(SEARCH_QUERY);
        PricingCalculatorBlock calculatorPage = searchResultPage
                .selectCalculatorSite();
        return calculatorPage
                .selectCalculatorType("Compute Engine")
                .selectNumberOfInstance("4")
                .selectOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .selectMachineClass("Regular")
                .selectMachineSeries("N1")
                .selectMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .clickInGPUsCheckBox()
                .enterNumberOfGPUs("1")
                .selectGPUType("NVIDIA Tesla V100")
                .selectLocalSSD("2x375 GB")
                .selectDataCenter("Taiwan (asia-east1)")
                .selectCommittedUsage("1 Year")
                .clickForAddedToEstimate();
    }
}
