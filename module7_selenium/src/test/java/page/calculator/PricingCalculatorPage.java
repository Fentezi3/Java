package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;
import wait.WaitService;

public class PricingCalculatorPage extends AbstractPage {
    private static final String CALCULATOR_TYPE = "//md-pagination-wrapper//md-tab-item[@aria-controls='tab-content-1']"
            + "//div[@class='tab-holder compute'][@title='%s']";
    private static final String I_FRAME_XPATH = "//article[@id='cloud-site']//devsite-iframe//iframe";
    private static final String MY_FRAME_XPATH = "//iframe[@id='myFrame']";
    private static final String INSTANCES_FIELD_ID = "input_62";
    private static final String OPERATING_SYSTEM_FIELD_ID = "select_value_label_55";
    private static final String OPERATING_SYSTEM_XPATH_PATTERN = "//md-option" + XPATH_PATTERN;
    private static final String MACHINE_CLASS_FIELD_ID = "select_value_label_56";
    private static final String MACHINE_CLASS_XPATH = "//*[@id='select_container_80']" + OPERATING_SYSTEM_XPATH_PATTERN;
    private static final String MACHINE_SERIES_FIELD_ID = "select_value_label_58";
    private static final String MACHINE_SERIES_XPATH = XPATH_PATTERN;
    private static final String MACHINE_TYPE_FIELD_ID = "select_88";
    private static final String MACHINE_TYPE_XPATH = XPATH_PATTERN;
    private static final String GPU_CHECKBOX_XPATH = "//form[./h2[text()='Instances']]" +
            "//md-checkbox[@aria-label='Add GPUs']";
    private static final String NUMBER_OF_GPU_FIELD_ID = "select_value_label_391";
    private static final String NUMBER_OF_GPU_XPATH = "//div[@id='select_container_394']" + XPATH_PATTERN;
    private static final String GPU_TYPE_FIELD_ID = "select_value_label_392";
    private static final String GPU_TYPE_XPATH = XPATH_PATTERN;
    private static final String LOCAL_SSD_FIELD_ID = "select_value_label_353";
    private static final String LOCAL_SSD_XPATH = XPATH_PATTERN;
    private static final String DATACENTER_LOCATION_FIELD_ID = "select_90";
    private static final String DATACENTER_LOCATION_XPATH = "//*[@id='select_container_91']" + XPATH_PATTERN;
    private static final String COMMITTED_USAGE_FIELD_ID = "select_97";
    private static final String COMMITTED_USAGE_XPATH = "//*[@id='select_container_98']" + XPATH_PATTERN;
    private static final String ADD_TO_ESTIMATE_XPATH = "//div[@ng-if='listingCtrl.showComputeEngine']" +
            "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']";

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage selectCalculatorType(String inputCalculatorType) {
        switchToFrame();
        String calculatorTypeXpath = String
                .format(CALCULATOR_TYPE, inputCalculatorType);
        WaitService.waitForPresenceOfElementByXpath(driver, calculatorTypeXpath);
        WebElement calculatorType = driver.findElement(By
                .xpath(calculatorTypeXpath));
        calculatorType.click();
        return this;
    }

    private void switchToFrame() {
        WebElement iFrame = driver.findElement(By.xpath(I_FRAME_XPATH));
        driver.switchTo().frame(iFrame);
        WebElement myFrame = driver.findElement(By.xpath(MY_FRAME_XPATH));
        driver.switchTo().frame(myFrame);
    }

    public PricingCalculatorPage selectNumberOfInstance(String inputNumber) {
        WebElement numberOfInstanceField = driver.findElement(By.id(INSTANCES_FIELD_ID));
        numberOfInstanceField.click();
        numberOfInstanceField.sendKeys(inputNumber);
        return this;
    }

    public PricingCalculatorPage selectOperatingSystem(String inputOperatingSystem) {
        WebElement operatingSystemField = driver.findElement(By.id(OPERATING_SYSTEM_FIELD_ID));
        operatingSystemField.click();
        WebElement operatingSystem = driver.findElement(By.xpath(String
                .format(OPERATING_SYSTEM_XPATH_PATTERN, inputOperatingSystem)));
        operatingSystem.click();
        return this;
    }

    public PricingCalculatorPage selectMachineClass(String inputMachineClass) {
        WebElement machineClassField = driver.findElement(By.id(MACHINE_CLASS_FIELD_ID));
        machineClassField.click();
        WebElement machineClass = driver.findElement(By.xpath(String
                .format(MACHINE_CLASS_XPATH, inputMachineClass)));
        machineClass.click();
        return this;
    }

    public PricingCalculatorPage selectMachineSeries(String inputMachineSeries) {
        WebElement machineSeriesField = driver.findElement(By.id(MACHINE_SERIES_FIELD_ID));
        machineSeriesField.click();
        String machineSeriesXpath = String.format(MACHINE_SERIES_XPATH, inputMachineSeries);
        WaitService.waitForElementToBeClickableByXpath(driver, machineSeriesXpath);
        WebElement machineSeries = driver.findElement(By.xpath(machineSeriesXpath));
        machineSeries.click();
        return this;
    }

    public PricingCalculatorPage selectMachineType(String inputMachineType) {
        WebElement machineTypeField = driver.findElement(By.id(MACHINE_TYPE_FIELD_ID));
        machineTypeField.click();
        String machineTypeXpath = String.format(MACHINE_TYPE_XPATH, inputMachineType);
        WaitService.waitForElementToBeClickableByXpath(driver, machineTypeXpath);
        WebElement machineType = driver.findElement(By.xpath(machineTypeXpath));
        machineType.click();
        return this;
    }

    public PricingCalculatorPage clickInGPUsCheckBox() {
        WebElement checkBoxGPUs = driver.findElement(By
                .xpath(GPU_CHECKBOX_XPATH));
        checkBoxGPUs.click();
        return this;
    }

    public PricingCalculatorPage enterNumberOfGPUs(String inputGPUNumber) {
        WebElement numberOfGPUField = driver.findElement(By.id(NUMBER_OF_GPU_FIELD_ID));
        numberOfGPUField.click();
        String numberOfGpuXpath = String.format(NUMBER_OF_GPU_XPATH, inputGPUNumber);
        WaitService.waitForElementToBeClickableByXpath(driver, numberOfGpuXpath);
        WebElement numberOfGPU = driver.findElement(By.xpath(numberOfGpuXpath));
        numberOfGPU.click();
        return this;
    }

    public PricingCalculatorPage selectGPUType(String inputGPUType) {
        WebElement gpuTypeField = driver.findElement(By.id(GPU_TYPE_FIELD_ID));
        gpuTypeField.click();
        String gpuTypeXpath = String.format(GPU_TYPE_XPATH, inputGPUType);
        WaitService.waitForElementToBeClickableByXpath(driver, gpuTypeXpath);
        WebElement gpuType = driver.findElement(By.xpath(gpuTypeXpath));
        gpuType.click();
        return this;
    }

    public PricingCalculatorPage selectLocalSSD(String inputLocalSSD) {
        WebElement localSSDField = driver.findElement(By.id(LOCAL_SSD_FIELD_ID));
        localSSDField.click();
        String localSSDXpath = String.format(LOCAL_SSD_XPATH, inputLocalSSD);
        WaitService.waitForElementToBeClickableByXpath(driver, localSSDXpath);
        WebElement localSSD = driver.findElement(By.xpath(localSSDXpath));
        localSSD.click();
        return this;
    }

    public PricingCalculatorPage selectDataCenter(String inputDataCenterLocation) {
        WebElement dataCenterLocationField = driver.findElement(By.id(DATACENTER_LOCATION_FIELD_ID));
        dataCenterLocationField.click();
        String locationXpath = String.format(DATACENTER_LOCATION_XPATH, inputDataCenterLocation);
        WaitService.waitForElementToBeClickableByXpath(driver, locationXpath);
        WebElement location = driver.findElement(By.xpath(locationXpath));
        location.click();
        return this;
    }

    public PricingCalculatorPage selectCommittedUsage(String inputUsage) {
        WebElement committedUsageField = driver.findElement(By.id(COMMITTED_USAGE_FIELD_ID));
        committedUsageField.click();
        String committedUsageXpath = String.format(COMMITTED_USAGE_XPATH, inputUsage);
        WaitService.waitForElementToBeClickableByXpath(driver, committedUsageXpath);
        WebElement committedUsage = driver.findElement(By.xpath(committedUsageXpath));
        committedUsage.click();
        return this;
    }

    public PricingResultPage clickForAddedToEstimate() {
        WebElement addToEstimate = driver.findElement(By
                .xpath(ADD_TO_ESTIMATE_XPATH));
        addToEstimate.click();
        return new PricingResultPage(driver);
    }
}
