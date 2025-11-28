import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Wait {
    @Test
    public void implicitwait() {
        WebDriver driver;
        By startbutton = By.tagName("button");
        By msg = By.cssSelector("#finish h4");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.navigate().to("http://aa-practice-test-automation.vercel.app/Pages/dynamicLoading.html");
        driver.findElement(startbutton).click();
    }

    public void explicitwait() {
        WebDriver driver;
        By startbutton = By.tagName("button");
        By msg = By.cssSelector("#finish h4");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://aa-practice-test-automation.vercel.app/Pages/dynamicLoading.html");
        driver.findElement(startbutton).click();
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(msg));
    }
} // Add this closing brace
