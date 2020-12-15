package test;

import model.VirtualMachine;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.GoogleCloudStartPage;
import page.PricingCalculatorBlock;
import page.PricingResultBlock;
import page.SearchResultPage;
import service.VirtualMachineCreator;

import static page.PricingResultBlock.FieldName.*;

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
        PricingResultBlock resultPage = createResultBlock();
        Assert.assertEquals(resultPage.getItemFieldValue(fieldName.getName()), itemFieldText);
    }

    @Test
    public void testEqualsTotalEstimatedCost() {
        PricingResultBlock resultPage = createResultBlock();
        Assert.assertEquals(resultPage.getCostFieldValue(), COST.getName() + "USD 5,523.47 per 1 month");
    }

    private PricingResultBlock createResultBlock() {
        VirtualMachine machine = VirtualMachineCreator.withCredentialsFromProperty();
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        SearchResultPage searchResultPage = googleCloudStartPage
                .openPage(GOOGLE_CLOUD_URL)
                .searchFor(SEARCH_QUERY);
        PricingCalculatorBlock calculatorPage = searchResultPage
                .selectCalculatorSite();
        return calculatorPage
                .selectCalculatorType(machine.getCalculatorType())
                .selectNumberOfInstance(machine.getNumberOfInstance())
                .selectOperatingSystem(machine.getOperatingSystem())
                .selectMachineClass(machine.getMachineClass())
                .selectMachineSeries(machine.getMachineSeries())
                .selectMachineType(machine.getMachineType())
                .clickInGPUsCheckBox()
                .enterNumberOfGPUs(machine.getNumberOfGPUs())
                .selectGPUType(machine.getGpuType())
                .selectLocalSSD(machine.getLocalSSD())
                .selectDataCenter(machine.getDataCenter())
                .selectCommittedUsage(machine.getCommittedUsage())
                .clickForAddedToEstimate();
    }
}
