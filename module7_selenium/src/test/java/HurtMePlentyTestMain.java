import org.testng.Assert;
import org.testng.annotations.Test;
import page.calculator.GoogleCloudStartPage;
import page.calculator.PricingResultPage;

public class HurtMePlentyTestMain extends AbstractTest {
    private static final String CHECK_VM_CLASS = "VM class: ";
    private static final String CHECK_INSTANCE_TYPE = "Instance type: ";
    private static final String CHECK_REGION = "Region: ";
    private static final String CHECK_LOCAL_SSD = "Total available local SSD space ";
    private static final String CHECK_COMMITMENT_TERM = "Commitment term: ";
    private static final String CHECK_COST = "Total Estimated Cost: ";
    private static final String VM_CLASS = "regular";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final String REGION = "Taiwan";
    private static final String LOCAL_SSD = "2x375 GiB";
    private static final String COMMITMENT_TERM = "1 Year";
    private static final String COST = "USD 5,523.47 per 1 month";

    @Test
    public void testEqualsVMClass() {
        PricingResultPage resultPage = createResultPage();
        String equalsReference = String.format(CHECK_VM_CLASS + VM_CLASS);
        Assert.assertEquals(resultPage.resultString(CHECK_VM_CLASS), equalsReference);
    }

    @Test
    public void testEqualsInstanceType() {
        PricingResultPage resultPage = createResultPage();
        String equalsReference = String.format(CHECK_INSTANCE_TYPE + INSTANCE_TYPE);
        Assert.assertEquals(resultPage.resultString(CHECK_INSTANCE_TYPE), equalsReference);
    }

    @Test
    public void testEqualsRegion() {
        PricingResultPage resultPage = createResultPage();
        String equalsReference = String.format(CHECK_REGION + REGION);
        Assert.assertEquals(resultPage.resultString(CHECK_REGION), equalsReference);
    }

    @Test
    public void testEqualsLocalSSD() {
        PricingResultPage resultPage = createResultPage();
        String equalsReference = String.format(CHECK_LOCAL_SSD + LOCAL_SSD);
        Assert.assertEquals(resultPage.resultString(CHECK_LOCAL_SSD), equalsReference);
    }

    @Test
    public void testEqualsCommitmentTerm() {
        PricingResultPage resultPage = createResultPage();
        String equalsReference = String.format(CHECK_COMMITMENT_TERM + COMMITMENT_TERM);
        Assert.assertEquals(resultPage.resultString(CHECK_COMMITMENT_TERM), equalsReference);
    }

    @Test
    public void testEqualsTotalEstimatedCost() {
        PricingResultPage resultPage = createResultPage();
        String equalsReference = String.format(CHECK_COST + COST);
        Assert.assertEquals(resultPage.resultString(CHECK_COST), equalsReference);
    }

    private PricingResultPage createResultPage() {
        return new GoogleCloudStartPage(driver)
                .openPage()
                .findInfoOnTheSite()
                .findCalculatorSite()
                .chooseComputerEngine()
                .chooseNumberOfInstance()
                .chooseOperatingSystem()
                .chooseMachineClass()
                .chooseMachineSeries()
                .chooseMachineType()
                .chooseGPUsCheckBox()
                .enterNumberOfGPUs()
                .chooseGPUtype()
                .chooseLocalSSD()
                .chooseDataCenter()
                .chooseCommittedUsage()
                .addToEstimate();
    }
}
