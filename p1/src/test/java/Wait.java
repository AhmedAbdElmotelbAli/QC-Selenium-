import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class Wait {
    @Test
    public void implicitwait() {
        WebDriver driver;
        By click = By.id("reveal");
        By sendtext = By.id("revealed");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(click).click();
        driver.findElement(sendtext).sendKeys("Hello");
    }

    @Test
    public void explicitwait() {
        WebDriver driver;
        By click = By.id("reveal");
        By sendtext = By.id("revealed");
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(click).click();
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendtext));
        driver.findElement(sendtext).sendKeys("Hello");
    }

    @Test
    public void fluentwait() {
        WebDriver driver;
        By click = By.id("reveal");
        By sendtext = By.id("revealed");

        driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(click).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(java.time.Duration.ofSeconds(10))
                .pollingEvery(java.time.Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendtext));
        driver.findElement(sendtext).sendKeys("Hello");

    }
}