import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalenderPageTest {
    private WebDriver driver;
    private CalendarPage calenderPage;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.bestcase.com/date-calculator");
        driver.manage().window().maximize();
        calenderPage = new CalendarPage(driver);

    }
    @Test
    public void testPickUpYear(){
        int day=15,month=2,year=2025;

        calenderPage.pickData(day,month,year);
        System.out.println(calenderPage.getDataValue());
        assertEquals(calenderPage.getDataValue(), String.format("%02d/%02d/%04d", month, day, year));
    }
}
