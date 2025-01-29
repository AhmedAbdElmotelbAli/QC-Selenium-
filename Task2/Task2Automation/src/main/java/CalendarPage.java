import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.http.WebSocket;
import java.time.Duration;
import java.util.List;

public class CalendarPage {
    private WebDriver driver;
    private  Actions action;
    private WebDriverWait wait;

    private By inputDataField =     By.id("txtStartDate");
    private By prevButton = By.cssSelector("div[style=''] th[class='prev']");
    private By nextButton = By.cssSelector("div[style=''] th[class='next']");
    private By switchButton = By.cssSelector("div[style=''] th[class='datepicker-switch']");
    private By yearsList = By.xpath("//span[contains(@class, 'year')]");
    String yearString = "//span[contains(@class, 'year') and (text()='%s')]";
    private By monthList = By.xpath("//span[contains(@class, 'month')]");
    private String dayList = "//td[@class!='old day' and @class!='new day'][text()='%s']";

    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        action.scrollByAmount(0,500).pause(300).perform();

    }

    public String getDataValue(){
       return driver.findElement(inputDataField).getAttribute("value");

    }
    public void selectYear(int year) {
        if(year>0) {
            driver.findElement(inputDataField).click();
            driver.findElement(switchButton).click();
            driver.findElement(switchButton).click();
            while (true) {
                List<WebElement> yearsElements = driver.findElements(yearsList);
                int firstYear = Integer.parseInt(yearsElements.getFirst().getText());
                int lastYear = Integer.parseInt(yearsElements.getLast().getText());

                if (year >= firstYear && year <= lastYear) {
                    System.out.println();
                    driver.findElement(By.xpath(String.format(yearString, Integer.toString(year)))).click();
                    break;
                } else if (year < firstYear) {
                    driver.findElement(prevButton).click();
                } else {
                    driver.findElement(nextButton).click();
                }

            }
        }else {
            System.out.println("year should great than Zero");
        }
    }
    public void selectMonth(int monthIndex){
        if(monthIndex>0 && monthIndex<=12) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(monthList));
            List<WebElement> monthElementList = driver.findElements(monthList);
            monthElementList.get(monthIndex - 1).click();
        }else {
            System.out.println("month between 1 to 12");
        }
    }
    public void selectDay(int Day){
        if(Day>1 && Day<=31) {
            driver.findElement(By.xpath(String.format(dayList, Integer.toString(Day)))).click();
        }else {
            System.out.println("Day Between 1 ---31");
        }
    }
    public void pickData(int day ,int month , int year ){
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }
}
