import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

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

    @Test
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

    @Test
    public void fluentwait() {
        WebDriver driver;
        By startbutton = By.tagName("button");
        By msg = By.cssSelector("#finish h4");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://aa-practice-test-automation.vercel.app/Pages/dynamicLoading.html");
        driver.findElement(startbutton).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(java.time.Duration.ofSeconds(10))
                .pollingEvery(java.time.Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg));
    }
}