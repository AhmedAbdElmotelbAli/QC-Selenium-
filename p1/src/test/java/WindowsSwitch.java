import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class WindowsSwitch {
    WebDriver driver;
    By clickHereLink = By.cssSelector(".example >a");
    By newWindowText = By.cssSelector("body >.example >h3");
    By text = By.tagName("h3");


    @Test
    public void windowsSwitch() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String mainWindowHandle = driver.getWindowHandle();
        driver.findElement(clickHereLink).click();
        //get all window handles and convert object (array) switch to the new one and convert it to string
        String newTab = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newTab);
        System.out.println(driver.findElement(newWindowText).getText());
        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.findElement(text).getText());
    }
}
