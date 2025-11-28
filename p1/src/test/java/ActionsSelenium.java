import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsSelenium {
    WebDriver driver;
    By rightClickButton = By.id("riClickBtn");
    By doubleClickButton = By.id("dblClickBtn");
    By avatar = By.cssSelector("[alt=\"User Avatar\"]");
    By image = By.cssSelector("[alt=\"my Image\"]");
    By dropZone = By.id("dropZone");

    @Test
    public void contextClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/mouse.html");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(rightClickButton)).perform();
    }

    @Test
    public void doubleClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/mouse.html");
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(doubleClickButton)).perform();
    }

    @Test
    public void dragDrop() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/dragDrop.html");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(image), driver.findElement(dropZone)).perform();
    }

    @Test
    public void clickAndHold() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/dragDrop.html");
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(image))
                .moveToElement(driver.findElement(dropZone))
                .release()
                .perform();
    }

    @Test
    public void hover() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(avatar)).perform();
    }
}
