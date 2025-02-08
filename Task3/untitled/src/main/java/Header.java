import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final static By registerButton = By.xpath("//a[contains(text(),'Register')]");
    private final static By userInfo = By.cssSelector("div.header a[href*='info']");

    public static RegisterPage navigateRegisterPage(WebDriver driver) {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }
    public static String getUserName(WebDriver driver) {

        return driver.findElement(userInfo).getText();
    }
}