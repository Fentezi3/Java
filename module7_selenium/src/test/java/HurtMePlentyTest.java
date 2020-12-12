import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.calculator.GoogleCloudStartPage;
import page.calculator.PricingCalculatorBlock;
import page.calculator.PricingResultBlock;
import page.calculator.SearchResultPage;

import static page.calculator.PricingResultBlock.FieldName.*;

public class HurtMePlentyTest extends AbstractTest {
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/ ";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {VM_CLASS,        VM_CLASS.getName()        + "regular"},
                {INSTANCE_TYPE,   INSTANCE_TYPE.getName()   + "n1-standard-8"},
                {REGION,          REGION.getName()          + "Taiwan"},
                {LOCAL_SSD,       LOCAL_SSD.getName()       + "2x375 GiB"},
                {COMMITMENT_TERM, COMMITMENT_TERM.getName() + "1 Year"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void testEqualsItemField(PricingResultBlock.FieldName fieldName, String itemFieldText) {
        PricingResultBlock resultPage = createResultPage();
        Assert.assertEquals(resultPage.getItemFieldValue(fieldName.getName()), itemFieldText);
    }

    @Test
    public void testEqualsTotalEstimatedCost() {
        PricingResultBlock resultPage = createResultPage();
        Assert.assertEquals(resultPage.getCostFieldValue(), COST.getName() + "USD 5,523.47 per 1 month");
    }

    private PricingResultBlock createResultPage() {
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
