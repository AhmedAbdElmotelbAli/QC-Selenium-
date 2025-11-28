import org.testng.annotations.Test;
import pages.DashboardPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BaseTest {
    @Test
    public void testSuccessLogin(){
        //Add userName
        loginPage.AddUserName("Admin");
        //Add passsword
        loginPage.AddPassword("admin123");
        //click login
        DashboardPage dashboard = loginPage.clickLoginButton();
        //Assert
       // assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(dashboard.isDashboardIcoinVisible(),"Dashboard Not Visible");

    }
    @Test
    public void testInvlaidUserName(){
        //Add userName
        loginPage.AddUserName("ads");
        //Add passsword
        loginPage.AddPassword("admin123");
        //click login
        loginPage.clickLoginButton();
        //Assert
        assertTrue(loginPage.isInvliadErrorMessageVisible(),"valid User name and see that enter invliad\n");

        }
    @Test
    public void testInvlaidPassword(){
        //Add userName
        loginPage.AddUserName("Admin");
        //Add passsword
        loginPage.AddPassword("admin1243");
        //click login
        loginPage.clickLoginButton();
        //Assert
        assertTrue(loginPage.isInvliadErrorMessageVisible(),"valid password and see that enter invliad\n");
    }
    @Test
    public void testEmptyPassword(){
        //Add userName
        loginPage.AddUserName("Admin");
        //Add passsword
        loginPage.AddPassword("");
        //click login
        loginPage.clickLoginButton();
        //Assert
        assertTrue(loginPage.isRequiredErrorMessageVisible(),"valid password and see that enter invliad\n");
    }
    @Test
    public void testEmptyUserName(){
        //Add userName
        loginPage.AddUserName("");
        //Add passsword
        loginPage.AddPassword("admin123");
        //click login
        loginPage.clickLoginButton();
        //Assert
        assertTrue(loginPage.isRequiredErrorMessageVisible(),"valid User name and see that enter invliad\n");
    }
    @Test
    public void testEmptyUserNameAndEmptyPassword(){
        //Add userName
        loginPage.AddUserName("");
        //Add passsword
        loginPage.AddPassword("");
        //click login
        loginPage.clickLoginButton();
        //Assert
        assertTrue(loginPage.isDuplicateRequiredErrorMessageVisible(),"valid User name and see that enter invliad\n");
    }
}
