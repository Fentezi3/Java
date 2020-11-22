import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rutracker.net/forum/index.php");

        WebElement searchInput = driver.findElement(By.name("nm"));
        searchInput.sendKeys("selenium java");

        WebElement searchBtn = driver.findElement(By.xpath("//*[@value='поиск']"));
        searchBtn.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
