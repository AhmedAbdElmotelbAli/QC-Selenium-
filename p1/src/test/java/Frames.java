import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Frames {
    WebDriver driver;
    By leftFrame = By.xpath("//body[contains(text(),'LEFT')]");
    By bottomFrame = By.xpath("//body[contains(.,'BOTTOM')]");

    @Test
    public void framesHandling() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //switch parent frame then top frame then left frame then back to top frame then parent frame then bottom frame
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(leftFrame).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(bottomFrame).getText());
    }
}
