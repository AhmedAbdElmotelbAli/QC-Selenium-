import DataReader.JSONReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterTests {
        private WebDriver driver;
        private RegisterPage registerPage;

        @BeforeMethod
        public void setup() {
                this.driver = new ChromeDriver();
                this.driver.get("https://demowebshop.tricentis.com/");
                this.driver.manage().window().maximize();
                this.registerPage = Header.navigateRegisterPage(driver);
        }
        @AfterMethod
        public void End() {
                this.driver.quit();
        }
        @DataProvider(name = "ValidRegister")
        public Object[][] readValidRegisterData(){
               return JSONReader.readJsonFile("RegisterTestData","validRegisterData");
        }

        @Test(dataProvider = "ValidRegister" , priority = 1)
        public void validRegisterDataTest(HashMap<String,String> RegisterData){
                String gander = RegisterData.get("gender") ;
                String firstName = RegisterData.get("firstName") ;
                String lastName = RegisterData.get("lastName") ;
                String email = System.currentTimeMillis()+ RegisterData.get("email") ;
                String password =RegisterData.get("password") ;
                String confirmPassword = RegisterData.get("confirmPassword") ;
                registerPage.enterRegisterData(gander,firstName,lastName,email,password,confirmPassword);
                registerPage.submitRegister();
                assertEquals(Header.getUserName(driver),email);
        }
        @DataProvider(name = "EmptyField")
        public Object[][] readEmptyRegisterData(){
                return JSONReader.readJsonFile("RegisterTestData","EmptyField");
        }
        @Test(dataProvider = "EmptyField" , priority = 3)
        public void emptyRegisterDataTest(HashMap<String,String> RegisterData){
                String gander = RegisterData.get("gender") ;
                String firstName = RegisterData.get("firstName") ;
                String lastName = RegisterData.get("lastName") ;
                String email;
                if(RegisterData.get("email") !="") {
                         email = System.currentTimeMillis() + RegisterData.get("email");
                }else{
                         email =RegisterData.get("email");
                }
                String password =RegisterData.get("password") ;
                String confirmPassword = RegisterData.get("confirmPassword") ;
                String ErrorMessage = RegisterData.get("ExpectedErrorMessage") ;
                registerPage.enterRegisterData(gander,firstName,lastName,email,password,confirmPassword);
                registerPage.submitRegister();
                assertEquals(registerPage.getErrorMessageText(),ErrorMessage);
        }
        @DataProvider(name = "wrongEmail")
        public Object[][] readWrongEmailRegisterData(){
                return JSONReader.readJsonFile("RegisterTestData","WrongEmail");
        }

        @Test(dataProvider = "wrongEmail" , priority = 3)
        public void wrongEmailRegisterDataTest(HashMap<String,String> RegisterData){
                String gander = RegisterData.get("gender") ;
                String firstName = RegisterData.get("firstName") ;
                String lastName = RegisterData.get("lastName") ;
                String email = RegisterData.get("email") ;
                String password =RegisterData.get("password") ;
                String confirmPassword = RegisterData.get("confirmPassword") ;
                String ErrorMessage = RegisterData.get("ExpectedErrorMessage") ;
                registerPage.enterRegisterData(gander,firstName,lastName,email,password,confirmPassword);
                registerPage.submitRegister();
                assertTrue(registerPage.isWrongEmailError());
        }
        @DataProvider(name = "wrongPassword")
        public Object[][] readWrongPasswordRegisterData(){
                return JSONReader.readJsonFile("RegisterTestData","wrongPassword");
        }

        @Test(dataProvider = "wrongPassword" , priority = 2)
        public void wrongPasswordRegisterDataTest(HashMap<String,String> RegisterData) {
                String gander = RegisterData.get("gender");
                String firstName = RegisterData.get("firstName");
                String lastName = RegisterData.get("lastName");
                String email = RegisterData.get("email");
                String password = RegisterData.get("password");
                String confirmPassword = RegisterData.get("confirmPassword");
                registerPage.enterRegisterData(gander,firstName,lastName,email,password,confirmPassword);
                registerPage.submitRegister();
                if(password.length()<6) {
                        assertTrue(registerPage.isLengthOk());
                }
                if(!confirmPassword.equals(password)){
                        assertTrue(registerPage.isPasswordMatch());
                }
        }


}
