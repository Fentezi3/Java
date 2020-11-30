package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPlatformPricingCalculator { //TODO
    private static final String COMPUTER_ENGINE_CLASSNAME =
            "md-tab ng-scope ng-isolate-scope md-ink-ripple md-active";
    private static final String NUMBER_OF_INSTANCES = "input_61";
    private static final String OPERATING_SYSTEM_ID = "select_value_label_54";
    WebDriver driver;
    public GoogleCloudPlatformPricingCalculator(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(className = COMPUTER_ENGINE_CLASSNAME)
    WebElement computerEngine;

    @FindBy(id = NUMBER_OF_INSTANCES)
    WebElement numberOfInstances;

    @FindBy(id = OPERATING_SYSTEM_ID)
    WebElement operatingSystem;


}
