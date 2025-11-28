import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

import java.io.File;

public class EmentAction {
    WebDriver driver;
    //By usernametraditional = By.id("inputUsername");
    By username = new ByChained(By.id("loginForm"), By.id("inputUsername"));

    By password = By.cssSelector("[type='password']");
    By login = RelativeLocator.with(By.tagName("button")).below(password);
    By uploadfile = By.id("regularFileInput");

    /*By loginfiled = new ByAll(
            By.id("inputUsername"),
            By.cssSelector("[type='password']")
    );*/

    @Test
    public void testcase() {
        ChromeOptions c = new ChromeOptions();
        c.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(c);
        maximizeWindow();
        navigateToUrl("https://aa-practice-test-automation.vercel.app/index.html");
        boolean userField = isdisplayed(username);
        boolean userField_enable = isenabled(username);
        boolean passField = isdisplayed(password);
        boolean passField_enable = isenabled(password);
        try {
            if (userField && passField && userField_enable && passField_enable) {
                typeText(username, "admin");
                typeText(password, "admin");
                clickElement(login);
                System.out.println("Login successful");
            } else {
                System.out.println("Username or password field is not displayed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Login elements not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error during login: " + e.getMessage());
        }

    }

    @Test
    public void uploadfiletest() {
        driver = new ChromeDriver();

        maximizeWindow();
        navigateToUrl("http://aa-practice-test-automation.vercel.app/Pages/uploadFile.html");
        setUploadfile(uploadfile, "src/main/resources/test.txt");
    }

    public void typeText(By by, String text) {
        clearText(by);
        driver.findElement(by).sendKeys(text);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void clearText(By by) {
        driver.findElement(by).clear();
    }

    public void setUploadfile(By by, String filepath) {
        clearText(by);
        String userDir = System.getProperty("user.dir") + File.separator;
        userDir = userDir + filepath;
        driver.findElement(by).sendKeys(userDir);
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public boolean isdisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public boolean isenabled(By by) {
        return driver.findElement(by).isEnabled();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}
