package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wait.WaitService;

public class PricingCalculatorBlock extends AbstractGooglePage {
    private static final String CALCULATOR_TYPE_XPATH = "//md-pagination-wrapper//md-tab-item[@aria-controls='tab-content-1']"
            + "//div[@class='tab-holder compute'][@title='%s']";
    private static final String INSTANCES_FIELD_XPATH = "//md-input-container//input[@name='quantity']";
    private static final String OPERATING_SYSTEM_FIELD_XPATH = "//md-select[contains(@aria-label,'Operating System / Software:')]";
    private static final String OPERATING_SYSTEM_XPATH_PATTERN = "//md-option" + DIV_WITH_TEXT;
    private static final String MACHINE_CLASS_FIELD_XPATH = "//md-select[@placeholder='VM Class']";
    private static final String MACHINE_CLASS_XPATH = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";
    private static final String MACHINE_SERIES_FIELD_XPATH = "//md-select[@placeholder='Series']";
    private static final String MACHINE_SERIES_XPATH = DIV_WITH_TEXT;
    private static final String MACHINE_TYPE_FIELD_XPATH = "//md-select[@placeholder='Instance type']";
    private static final String MACHINE_TYPE_XPATH = DIV_WITH_TEXT;
    private static final String GPU_CHECKBOX_XPATH = "//form[./h2[text()='Instances']]" +
            "//md-checkbox[@aria-label='Add GPUs']";
    private static final String NUMBER_OF_GPU_FIELD_XPATH = "//md-select[@placeholder='Number of GPUs']";
    private static final String NUMBER_OF_GPU_XPATH = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";
    private static final String GPU_TYPE_FIELD_XPATH = "//md-select[@placeholder='GPU type']";
    private static final String GPU_TYPE_XPATH = DIV_WITH_TEXT;
    private static final String LOCAL_SSD_FIELD_XPATH = "//form[./h2[text()='Instances']]//md-select[@placeholder='Local SSD']";
    private static final String LOCAL_SSD_XPATH = DIV_WITH_TEXT;
    private static final String DATACENTER_LOCATION_FIELD_XPATH = "//form[./h2[text()='Instances']]//md-select[@placeholder='Datacenter location']";
    private static final String DATACENTER_LOCATION_XPATH = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";
    private static final String COMMITTED_USAGE_FIELD_XPATH = "//form[./h2[text()='Instances']]//md-select[@placeholder='Committed usage']";
    private static final String COMMITTED_USAGE_XPATH = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'%s')]";
    private static final String ADD_TO_ESTIMATE_XPATH = "//div[@ng-if='listingCtrl.showComputeEngine']" +
            "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']";

    public PricingCalculatorBlock(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorBlock selectCalculatorType(String inputCalculatorType) {
        switchToFrame();
        String calculatorTypeXpath = String
                .format(CALCULATOR_TYPE_XPATH, inputCalculatorType);
        WaitService.waitForPresenceOfElementByXpath(driver, calculatorTypeXpath);
        WebElement calculatorType = driver.findElement(By
                .xpath(calculatorTypeXpath));
        calculatorType.click();
        return this;
    }

    public PricingCalculatorBlock selectNumberOfInstance(String inputNumber) {
        WebElement numberOfInstanceField = driver.findElement(By.xpath(INSTANCES_FIELD_XPATH));
        numberOfInstanceField.click();
        numberOfInstanceField.sendKeys(inputNumber);
        return this;
    }

    public PricingCalculatorBlock selectOperatingSystem(String inputOperatingSystem) {
        WebElement operatingSystemField = driver.findElement(By.xpath(OPERATING_SYSTEM_FIELD_XPATH));
        operatingSystemField.click();
        WebElement operatingSystem = driver.findElement(By.xpath(String
                .format(OPERATING_SYSTEM_XPATH_PATTERN, inputOperatingSystem)));
        operatingSystem.click();
        return this;
    }

    public PricingCalculatorBlock selectMachineClass(String inputMachineClass) {
        WebElement machineClassField = driver.findElement(By.xpath(MACHINE_CLASS_FIELD_XPATH));
        machineClassField.click();
        WaitService.waitForElementToBeClickableByXpath(driver,String
                .format(MACHINE_CLASS_XPATH, inputMachineClass));
        WebElement machineClass = driver.findElement(By.xpath(String
                .format(MACHINE_CLASS_XPATH, inputMachineClass)));
        machineClass.click();
        return this;
    }

    public PricingCalculatorBlock selectMachineSeries(String inputMachineSeries) {
        WebElement machineSeriesField = driver.findElement(By.xpath(MACHINE_SERIES_FIELD_XPATH));
        machineSeriesField.click();
        String machineSeriesXpath = String.format(MACHINE_SERIES_XPATH, inputMachineSeries);
        WaitService.waitForElementToBeClickableByXpath(driver, machineSeriesXpath);
        WebElement machineSeries = driver.findElement(By.xpath(machineSeriesXpath));
        machineSeries.click();
        return this;
    }

    public PricingCalculatorBlock selectMachineType(String inputMachineType) {
        //WaitService.waitForElementToBeClickableByXpath(driver,MACHINE_TYPE_FIELD_ID);
        WebElement machineTypeField = driver.findElement(By.xpath(MACHINE_TYPE_FIELD_XPATH));
        machineTypeField.click();
        String machineTypeXpath = String.format(MACHINE_TYPE_XPATH, inputMachineType);
        WaitService.waitForElementToBeClickableByXpath(driver, machineTypeXpath);
        WebElement machineType = driver.findElement(By.xpath(machineTypeXpath));
        machineType.click();
        return this;
    }

    public PricingCalculatorBlock clickInGPUsCheckBox() {
        WebElement checkBoxGPUs = driver.findElement(By
                .xpath(GPU_CHECKBOX_XPATH));
        checkBoxGPUs.click();
        return this;
    }

    public PricingCalculatorBlock enterNumberOfGPUs(String inputGPUNumber) {
        WebElement numberOfGPUField = driver.findElement(By.xpath(NUMBER_OF_GPU_FIELD_XPATH));
        numberOfGPUField.click();
        String numberOfGpuXpath = String.format(NUMBER_OF_GPU_XPATH, inputGPUNumber);
        WaitService.waitForElementToBeClickableByXpath(driver, numberOfGpuXpath);
        WebElement numberOfGPU = driver.findElement(By.xpath(numberOfGpuXpath));
        numberOfGPU.click();
        return this;
    }

    public PricingCalculatorBlock selectGPUType(String inputGPUType) {
        WebElement gpuTypeField = driver.findElement(By.xpath(GPU_TYPE_FIELD_XPATH));
        gpuTypeField.click();
        String gpuTypeXpath = String.format(GPU_TYPE_XPATH, inputGPUType);
        WaitService.waitForElementToBeClickableByXpath(driver, gpuTypeXpath);
        WebElement gpuType = driver.findElement(By.xpath(gpuTypeXpath));
        gpuType.click();
        return this;
    }

    public PricingCalculatorBlock selectLocalSSD(String inputLocalSSD) {
        WebElement localSSDField = driver.findElement(By.xpath(LOCAL_SSD_FIELD_XPATH));
        localSSDField.click();
        String localSSDXpath = String.format(LOCAL_SSD_XPATH, inputLocalSSD);
        WaitService.waitForElementToBeClickableByXpath(driver, localSSDXpath);
        WebElement localSSD = driver.findElement(By.xpath(localSSDXpath));
        localSSD.click();
        return this;
    }

    public PricingCalculatorBlock selectDataCenter(String inputDataCenterLocation) {
        WebElement dataCenterLocationField = driver.findElement(By.xpath(DATACENTER_LOCATION_FIELD_XPATH));
        dataCenterLocationField.click();
        String locationXpath = String.format(DATACENTER_LOCATION_XPATH, inputDataCenterLocation);
        WaitService.waitForElementToBeClickableByXpath(driver, locationXpath);
        WebElement location = driver.findElement(By.xpath(locationXpath));
        location.click();
        return this;
    }

    public PricingCalculatorBlock selectCommittedUsage(String inputUsage) {
        WebElement committedUsageField = driver.findElement(By.xpath(COMMITTED_USAGE_FIELD_XPATH));
        committedUsageField.click();
        String committedUsageXpath = String.format(COMMITTED_USAGE_XPATH, inputUsage);
        WaitService.waitForElementToBeClickableByXpath(driver, committedUsageXpath);
        WebElement committedUsage = driver.findElement(By.xpath(committedUsageXpath));
        committedUsage.click();
        return this;
    }

    public PricingResultBlock clickForAddedToEstimate() {
        driver.findElement(By
                .xpath(ADD_TO_ESTIMATE_XPATH)).click();
        return new PricingResultBlock(driver);
    }
}
