package page.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.AbstractPage;
import wait.WaitMethod;

public class PricingCalculator extends AbstractPage {
    public PricingCalculator(WebDriver driver) {
        super(driver);
    }

    public PricingCalculator chooseComputerEngine() {
        WebElement iFrame = driver.findElement(By.xpath("//article[@id='cloud-site']//devsite-iframe//iframe"));
        driver.switchTo().frame(iFrame);
        WebElement myFrame = driver.findElement(By.xpath("//iframe[@id='myFrame']"));
        driver.switchTo().frame(myFrame);
        WaitMethod.createWaitWithXpath(driver, "//md-pagination-wrapper//md-tab-item[@aria-controls='tab-content-1']");
        WebElement computerEngine = driver.findElement(By
                .xpath("//md-pagination-wrapper//md-tab-item[@aria-controls='tab-content-1']"));
        computerEngine.click();
        return this;
    }

    public PricingCalculator chooseNumberOfInstance() {
        WebElement numberOfInstances = driver.findElement(By.id("input_62"));
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        return this;
    }

    public PricingCalculator chooseOperatingSystem() {
        WebElement operatingSystem = driver.findElement(By.id("select_value_label_55"));
        operatingSystem.click();
        WebElement opSys = driver.findElement(By.id("select_option_64"));
        opSys.click();
        return this;
    }

    public PricingCalculator chooseMachineClass() {
        WebElement machineClass = driver.findElement(By.id("select_value_label_56"));
        machineClass.click();
        WebElement regularClass = driver.findElement(By.id("select_option_77")); //should come from method
        regularClass.click();
        return this;
    }

    public PricingCalculator chooseMachineSeries() {
        WebElement machineSeries = driver.findElement(By.id("select_value_label_58"));
        machineSeries.click();
        WaitMethod.createClickableWaitWithXpath(driver, "//md-option[@value='n1']");
        WebElement n1Series = driver.findElement(By.xpath("//md-option[@value='n1']"));
        n1Series.click();
        return this;
    }

    public PricingCalculator chooseMachineType() {
        WebElement machineType = driver.findElement(By.id("select_88"));
        machineType.click();
        WaitMethod.createClickableWaitWithXpath(driver, "//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
        WebElement standart8type = driver.findElement(By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")); //should come from method
        standart8type.click();
        return this;
    }

    public PricingCalculator chooseGPUsCheckBox() {
        WebElement checkBoxGPUs = driver.findElement(By
                .xpath("//form[./h2[text()='Instances']]//md-checkbox[@aria-label='Add GPUs']"));
        checkBoxGPUs.click();
        return this;
    }

    public PricingCalculator enterNumberOfGPUs() {
        WebElement numberGPU = driver.findElement(By.id("select_value_label_391"));
        numberGPU.click();
        WaitMethod.createClickableWaitWithID(driver, "select_option_398");
        WebElement one = driver.findElement(By.id("select_option_398"));
        one.click();
        return this;
    }

    public PricingCalculator chooseGPUtype() {
        WebElement gpuType = driver.findElement(By.id("select_value_label_392"));
        gpuType.click();
        WaitMethod.createClickableWaitWithXpath(driver, "//*[@value='NVIDIA_TESLA_V100']");
        WebElement v100type = driver.findElement(By.xpath("//*[@value='NVIDIA_TESLA_V100']"));
        v100type.click();
        return this;
    }


    public PricingCalculator chooseLocalSSD() {
        WebElement localSSD = driver.findElement(By.id("select_value_label_353"));
        localSSD.click();
        WaitMethod.createClickableWaitWithID(driver, "select_option_380");
        WebElement neededLocalSSD = driver.findElement(By.id("select_option_380")); //should come from method
        neededLocalSSD.click();
        return this;
    }

    public PricingCalculator chooseDataCenter() {
        WebElement datacenterLocation = driver.findElement(By.id("select_90"));
        datacenterLocation.click();
        WaitMethod.createClickableWaitWithID(driver, "select_option_205");
        WebElement taiwanLocation = driver.findElement(By.id("select_option_205")); //should come from method
        taiwanLocation.click();
        return this;
    }

    public PricingCalculator chooseCommittedUsage() {
        WebElement committedUsage = driver.findElement(By.id("select_97"));
        committedUsage.click();
        WaitMethod.createClickableWaitWithID(driver, "select_option_95");
        WebElement oneYearUsage = driver.findElement(By.id("select_option_95")); //should come from method
        oneYearUsage.click();
        return this;
    }

    public PricingResultPage addToEstimate() {
        WebElement estimate = driver.findElement(By
                .xpath("//div[@ng-if='listingCtrl.showComputeEngine']" +
                        "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']"));
        estimate.click();
        return new PricingResultPage(driver);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
