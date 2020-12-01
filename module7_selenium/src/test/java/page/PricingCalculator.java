package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingCalculator extends AbstractPage { //TODO
    private static final String COMPUTER_ENGINE_CLASSNAME =
            "md-tab ng-scope ng-isolate-scope md-ink-ripple md-active";
    private static final String NUMBER_OF_INSTANCES = "input_61";
    private static final String OPERATING_SYSTEM_ID = "select_value_label_54";
    private static final String OPERATING_SYSTEM_FREE_MACHINE_ID = "select_option_63";
    private static final String MACHINE_CLASS_id = "select_option_76";

    @FindBy(className = COMPUTER_ENGINE_CLASSNAME)
    WebElement computerEngine;

    @FindBy(id = NUMBER_OF_INSTANCES)
    WebElement numberOfInstances;

    @FindBy(id = OPERATING_SYSTEM_ID)
    WebElement operatingSystem;

    @FindBy(id = "select_value_label_55")
    WebElement machineClass;

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public PricingCalculator(WebDriver driver) {
        super(driver);
    }

    public PricingCalculator chooseComputerEngine(){
        computerEngine.click();
        //wait
        return this;
    }

    public PricingCalculator chooseNumberOfInstance(){
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        return this;
    }

    public PricingCalculator chooseOperatingSystem() {
        operatingSystem.click();
        WebElement opSys = driver.findElement(By.id(OPERATING_SYSTEM_FREE_MACHINE_ID));
        opSys.click();
        return this;
    }

    public PricingCalculator chooseMachineClass(){
        machineClass.click();
        WebElement regularClass = driver.findElement(By.id(MACHINE_CLASS_id));
        regularClass.click();
        return this;
    }

    public PricingCalculator choose(){
        return this;
    }
}
