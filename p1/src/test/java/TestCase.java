import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase {
    WebDriver driver;

    // Test runner
    @Test
    public void test1() {
        driver = new ChromeDriver();
        maximizeWindow();
        navigateToUrl("https://www.google.com");
        navigateToUrl("https://www.bing.com");
        navigateBack();
        navigateForward();
        refreshPage();
        getTitle();
        getWindowHandle();

    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void setposition(int x, int y) {
        driver.manage().window().setPosition(new org.openqa.selenium.Point(x, y));
    }

    public void setSize(int width, int height) {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
    }

    public void fullscreen() {
        driver.manage().window().fullscreen();
    }

    public void getcurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }

    public void getTitle() {
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }

    public void getpageSource() {
        String pageSource = driver.getPageSource();
        System.out.println("Page Source: " + pageSource);
    }

    public void getWindowHandle() {
        String windowHandle = driver.getWindowHandle();
        System.out.println("Window Handle: " + windowHandle);
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }
}
