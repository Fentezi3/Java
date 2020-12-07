package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;
import wait.WaitService;

public class PricingCalculator extends AbstractPage {
    public static final String XPATH_REFERENCE = "//div[contains(text(),'%s')]";
    public static final String CALCULATOR_TYPE = "//md-pagination-wrapper//md-tab-item[@aria-controls='tab-content-1']"
            + "//div[@class='tab-holder compute'][@title='%s']";
    public static final String I_FRAME = "//article[@id='cloud-site']//devsite-iframe//iframe";
    public static final String MY_FRAME = "//iframe[@id='myFrame']";
    public static final String INSTANCES_FIELD_ID = "input_62";
    public static final String OPERATING_SYSTEM_FIELD_ID = "select_value_label_55";
    public static final String OPERATING_SYSTEM_XPATH = "//md-option" + XPATH_REFERENCE;
    public static final String MACHINE_CLASS_FIELD_ID = "select_value_label_56";
    public static final String MACHINE_CLASS_XPATH = "//*[@id='select_container_80']" + OPERATING_SYSTEM_XPATH;
    public static final String MACHINE_SERIES_FIELD_ID = "select_value_label_58";
    public static final String MACHINE_SERIES_XPATH = XPATH_REFERENCE;
    public static final String MACHINE_TYPE_FIELD_ID = "select_88";
    public static final String MACHINE_TYPE_XPATH = XPATH_REFERENCE;
    public static final String GPU_CHECKBOX_XPATH = "//form[./h2[text()='Instances']]" +
            "//md-checkbox[@aria-label='Add GPUs']";
    public static final String NUMBER_OF_GPU_FIELD_ID = "select_value_label_391";
    public static final String NUMBER_OF_GPU_XPATH = "//div[@id='select_container_394']" + XPATH_REFERENCE;
    public static final String GPU_TYPE_FIELD_ID = "select_value_label_392";
    public static final String GPU_TYPE_XPATH = XPATH_REFERENCE;
    public static final String LOCAL_SSD_FIELD_ID = "select_value_label_353";
    public static final String LOCAL_SSD_XPATH = XPATH_REFERENCE;
    public static final String DATACENTER_LOCATION_FIELD_ID = "select_90";
    public static final String DATACENTER_LOCATION_XPATH = "//*[@id='select_container_91']" + XPATH_REFERENCE;
    public static final String COMMITTED_USAGE_FIELD_ID = "select_97";
    public static final String COMMITTED_USAGE_XPATH = "//*[@id='select_container_98']" + XPATH_REFERENCE;
    public static final String ADD_TO_ESTIMATE_XPATH = "//div[@ng-if='listingCtrl.showComputeEngine']" +
            "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']";

    public PricingCalculator(WebDriver driver) {
        super(driver);
    }

    public PricingCalculator selectCalculatorType(String inputCalculatorType) {
        switchToFrame();
        String xpath = String
                .format(CALCULATOR_TYPE, inputCalculatorType);
        WaitService.waitForPresenceOfElementByXpath(driver, xpath);
        WebElement calculatorType = driver.findElement(By
                .xpath(xpath));
        calculatorType.click();
        return this;
    }

    private void switchToFrame() {
        WebElement iFrame = driver.findElement(By.xpath(I_FRAME));
        driver.switchTo().frame(iFrame);
        WebElement myFrame = driver.findElement(By.xpath(MY_FRAME));
        driver.switchTo().frame(myFrame);
    }

    public PricingCalculator selectNumberOfInstance(String inputNumber) {
        WebElement numberOfInstanceField = driver.findElement(By.id(INSTANCES_FIELD_ID));
        numberOfInstanceField.click();
        numberOfInstanceField.sendKeys(inputNumber);
        return this;
    }

    public PricingCalculator selectOperatingSystem(String inputOperatingSystem) {
        WebElement operatingSystemField = driver.findElement(By.id(OPERATING_SYSTEM_FIELD_ID));
        operatingSystemField.click();
        String xpath = String.format(OPERATING_SYSTEM_XPATH, inputOperatingSystem);
        WebElement operatingSystem = driver.findElement(By.xpath(xpath));
        operatingSystem.click();
        return this;
    }

    public PricingCalculator selectMachineClass(String inputMachineClass) {
        WebElement machineClassField = driver.findElement(By.id(MACHINE_CLASS_FIELD_ID));
        machineClassField.click();
        String xpath = String.format(MACHINE_CLASS_XPATH, inputMachineClass);
        WebElement machineClass = driver.findElement(By.xpath(xpath));
        machineClass.click();
        return this;
    }

    public PricingCalculator selectMachineSeries(String inputMachineSeries) {
        WebElement machineSeriesField = driver.findElement(By.id(MACHINE_SERIES_FIELD_ID));
        machineSeriesField.click();
        String xpath = String.format(MACHINE_SERIES_XPATH, inputMachineSeries);
        WaitService.waitForElementToBeClickableByXpath(driver, xpath);
        WebElement machineSeries = driver.findElement(By.xpath(xpath));
        machineSeries.click();
        return this;
    }

    public PricingCalculator selectMachineType(String inputMachineType) {
        WebElement machineTypeField = driver.findElement(By.id(MACHINE_TYPE_FIELD_ID));
        machineTypeField.click();
        String xpath = String.format(MACHINE_TYPE_XPATH, inputMachineType);
        WaitService.waitForElementToBeClickableByXpath(driver, xpath);
        WebElement machineType = driver.findElement(By.xpath(xpath));
        machineType.click();
        return this;
    }

    public PricingCalculator clickInGPUsCheckBox() {
        WebElement checkBoxGPUs = driver.findElement(By
                .xpath(GPU_CHECKBOX_XPATH));
        checkBoxGPUs.click();
        return this;
    }

    public PricingCalculator enterNumberOfGPUs(String inputGPUNumber) {
        WebElement numberOfGPUField = driver.findElement(By.id(NUMBER_OF_GPU_FIELD_ID));
        numberOfGPUField.click();
        String xpath = String.format(NUMBER_OF_GPU_XPATH, inputGPUNumber);
        WaitService.waitForElementToBeClickableByXpath(driver, xpath);
        WebElement numberOfGPU = driver.findElement(By.xpath(xpath));
        numberOfGPU.click();
        return this;
    }

    public PricingCalculator selectGPUType(String inputGPUType) {
        WebElement gpuTypeField = driver.findElement(By.id(GPU_TYPE_FIELD_ID));
        gpuTypeField.click();
        String xpath = String.format(GPU_TYPE_XPATH, inputGPUType);
        WaitService.waitForElementToBeClickableByXpath(driver, xpath);
        WebElement gpuType = driver.findElement(By.xpath(xpath));
        gpuType.click();
        return this;
    }


    public PricingCalculator selectLocalSSD(String inputLocalSSD) {
        WebElement localSSDField = driver.findElement(By.id(LOCAL_SSD_FIELD_ID));
        localSSDField.click();
        String xpath = String.format(LOCAL_SSD_XPATH, inputLocalSSD);
        WaitService.waitForElementToBeClickableByXpath(driver, xpath);
        WebElement localSSD = driver.findElement(By.xpath(xpath));
        localSSD.click();
        return this;
    }

    public PricingCalculator selectDataCenter(String inputDataCenterLocation) {
        WebElement dataCenterLocationField = driver.findElement(By.id(DATACENTER_LOCATION_FIELD_ID));
        dataCenterLocationField.click();
        String xpath = String.format(DATACENTER_LOCATION_XPATH, inputDataCenterLocation);
        WaitService.waitForElementToBeClickableByXpath(driver, xpath);
        WebElement location = driver.findElement(By.xpath(xpath));
        location.click();
        return this;
    }

    public PricingCalculator selectCommittedUsage(String inputUsage) {
        WebElement committedUsageField = driver.findElement(By.id(COMMITTED_USAGE_FIELD_ID));
        committedUsageField.click();
        String xpath = String.format(COMMITTED_USAGE_XPATH, inputUsage);
        WaitService.waitForElementToBeClickableByXpath(driver, xpath);
        WebElement committedUsage = driver.findElement(By.xpath(xpath));
        committedUsage.click();
        return this;
    }

    public PricingResultPage clickForAddedToEstimate() {
        WebElement addToEstimate = driver.findElement(By
                .xpath(ADD_TO_ESTIMATE_XPATH));
        addToEstimate.click();
        return new PricingResultPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
