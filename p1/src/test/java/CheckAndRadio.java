import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CheckAndRadio {
    WebDriver driver;
    By checkBox1 = By.id("noClub");
    By ahlyCheckBox = By.id("Ahly");
    By zamalekCheckBox = By.id("Zamalek");
    By highSchool = By.id("radio-button-1");
    By college = By.id("radio-button-2");
    By gradSchool = By.id("radio-button-3");

    @Test
    public void checkBox() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/checkbox_Radio.html");
        driver.findElement(checkBox1).click();
        System.out.println(driver.findElement(ahlyCheckBox).isSelected());
    }

    @Test
    public void radio() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://aa-practice-test-automation.vercel.app/Pages/checkbox_Radio.html");
        if (!driver.findElement(highSchool).isSelected()) driver.findElement(highSchool).click();
    }
}
