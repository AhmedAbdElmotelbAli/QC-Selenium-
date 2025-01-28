package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    private WebDriver driver ;
    private WebDriverWait wait;
    //webelements
    private By userNameField = By.cssSelector("input[name='username']");
    private By passwordField = By.cssSelector("input[name='password']");
    private By loginPage = By.cssSelector(".oxd-button.orangehrm-login-button");
    private By invliadErrorMessage = By.xpath("//p[contains(.,'Invalid credentials')]");
    private By requiredErrorMessage = By.cssSelector("span.oxd-input-field-error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    //methods
    public void AddUserName(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(userName);

    }

    public void AddPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginPage).click();
        return new DashboardPage(driver);
    }
    public boolean isInvliadErrorMessageVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(invliadErrorMessage));
        return driver.findElement(invliadErrorMessage).isDisplayed();
    }
    public boolean isRequiredErrorMessageVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMessage));
        return driver.findElement(requiredErrorMessage).isDisplayed();
    }
    public boolean isDuplicateRequiredErrorMessageVisible(){
       List<WebElement> requiredErrorList = driver.findElements(requiredErrorMessage);
        for (WebElement webElement : requiredErrorList) {
            if (!webElement.isDisplayed()) {
                return false;
            }

        }
        return true;

    }
}
