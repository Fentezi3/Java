package bring_It_on.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinResultPage {
    public String titleString;
    public String bashString;
    public String codeString;
    private WebDriver driver;

    public PastebinResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String resultTitle() {
        WebElement title = driver.findElement(By.xpath("//*[text()='how to gain dominance among developers']"));
        return titleString = title.getText();
    }

    public String bashSyntax() {
        WebElement bash = driver.findElement(By.xpath("//*[text()='Bash']"));
        bashString = bash.getAttribute("innerText");
        return bashString;
    }

    public String codeIsCorrect() {
        WebElement code = driver.findElement(By.className("textarea"));
        codeString = code.getAttribute("value");
        return codeString;
    }
}
