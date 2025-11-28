import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDown {
    WebDriver driver;

    @Test
    public void testDropDown() {
        ChromeOptions c = new ChromeOptions();
        c.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(c);
        maximizeWindow();
        navigateToUrl("https://the-internet.herokuapp.com/dropdown");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds

        By dropdown = By.id("dropdown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue("2");
        
        driver.findElement(dropdown).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();


    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}
