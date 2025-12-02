import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;
    By jsAlertButton = By.cssSelector("[onclick=\"jsAlert()\"]");
    By jsAlertButton1 = By.cssSelector("[onclick=\"jsConfirm()\"]");
    By jsAlertButton2 = By.cssSelector("[onclick=\"jsPrompt()\"]");

    @Test
    public void alertsHandling() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsAlertButton).click();
        driver.switchTo().alert().accept();
        driver.findElement(jsAlertButton1).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(jsAlertButton2).click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        //to be continued
    }
}
