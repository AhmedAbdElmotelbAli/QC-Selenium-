import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterPage {
        private WebDriver driver;
        private Actions action;
        private WebDriverWait wait;

        private final By registerFrom =  By.cssSelector("div.page.registration-page");
        private final By genderMale = By.id("gender-male");
        private final By genderFemale = By.id("gender-female");
        private final By firstNameField = By.id("FirstName");
        private final By lastNameField = By.id("LastName");
        private final By emailField = By.id("Email");
        private final By passwordField = By.id("Password");
        private final By confirmPasswordField = By.id("ConfirmPassword");
        private final By registerButtonField = By.id("register-button");

        private final By ErrorPasswordLength = By.xpath("//span[@for='Password']");
        private final By ErrorPasswordNotMatch = By.xpath("//span[@for='ConfirmPassword']");

        private final By errorIsRequired = By.xpath("//span[contains(text(),'is required')]");
        private final By errorWrongEnail = By.xpath("//span[contains(text(),'Wrong email')]");


        public RegisterPage(WebDriver driver) {
                this.driver = driver;
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(8L));
        }
        public void enterRegisterData(String gander , String firstName , String lastName ,String email,String password , String confirmPassword){
                if(gander.equalsIgnoreCase("male")){
                        driver.findElement(genderMale).click();
                } else if (gander.equalsIgnoreCase("female")) {
                        driver.findElement(genderFemale).click();
                }
                driver.findElement(firstNameField).sendKeys(firstName);
                driver.findElement(lastNameField).sendKeys(lastName);
                driver.findElement(emailField).sendKeys(email);
                driver.findElement(passwordField).sendKeys(password);
                driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        }
        public void submitRegister(){
                driver.findElement(registerButtonField).click();
        }
        public String getErrorMessageText(){
                return driver.findElement(errorIsRequired).getText();

        }
        public Boolean isWrongEmailError(){
               return  driver.findElement(errorWrongEnail).isDisplayed();
        }
        public Boolean isLengthOk(){
                return driver.findElement(ErrorPasswordLength).getText().equalsIgnoreCase("The password should have at least 6 characters.");

        }
        public Boolean isPasswordMatch(){
                return driver.findElement(ErrorPasswordNotMatch).getText().equalsIgnoreCase("The password and confirmation password do not match.");

        }

}
