package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    //webelements
    private WebDriver driver ;
    private WebDriverWait wait;
    private By dashboardIcoin = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    //methods
    public boolean isDashboardIcoinVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIcoin));
        return driver.findElement(dashboardIcoin).isDisplayed();
    }
}
