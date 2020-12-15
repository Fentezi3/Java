package test;

import model.VirtualMachine;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import service.VirtualMachineCreator;
import util.TabUtils;

public class HardcoreTest extends AbstractTest {
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/ ";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";
    @Test
    public void testResultInEmailEqualsManualResult() {
        PricingResultBlock resultPage = createResultBlock();

        String costInResultPage = resultPage.getCostFieldValue();
        SendEmailBlock sendEmail = resultPage.selectEmailEstimate();
        TabUtils.createNewTab();
        TabUtils.switchToTab(1);

        EmailPage emailPage = new EmailPage(driver);
        emailPage.openEmailPage();
        String email = emailPage.copyEmail();
        TabUtils.switchToTab(0);

        sendEmail.sendEmail(email);
        TabUtils.switchToTab(1);

        String costInEmail = emailPage.getMonthlyCostFromMail();
        Assert.assertTrue(costInResultPage.contains(costInEmail));
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
