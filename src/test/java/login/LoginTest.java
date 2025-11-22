package login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.beforeMethod.SetupBrowser;

public class LoginTest extends SetupBrowser {

    public static String expectedErrorText = "Invalid username or password. Please try again.";
    private LoginLocators locate;

    @BeforeMethod
    public void init() {
        locate = new LoginLocators(page); // Now page is initialized
    }

    @Test
    public void loginWithValidCred() throws InterruptedException {
        locate.enterPhoneNumber("admin", "admin123");
        locate.clickLogin();
        Thread.sleep(3000);
    }

    @Test
    public void loginWithInvalidEmail() throws InterruptedException {
        locate.enterPhoneNumber("adminnn", "admin123");
        locate.clickLogin();
        String actualError = locate.getErrorText();
        System.out.println("Error message: " + actualError);
        Assert.assertEquals(actualError, expectedErrorText);   
    }

    @Test
    public void loginWithInvalidPass() throws InterruptedException {
        locate.enterPhoneNumber("admin", "admin1234");
        locate.clickLogin();
        String actualError = locate.getErrorText();
        System.out.println("Error message: " + actualError);
        Assert.assertEquals(actualError, expectedErrorText);   
    }

    @Test
    public void loginWithInvalidCred() throws InterruptedException {
        locate.enterPhoneNumber("adminnn", "admin12345");
        locate.clickLogin();
        String actualError = locate.getErrorText();
        System.out.println("Error message: " + actualError);
        Assert.assertEquals(actualError, expectedErrorText);   
    }

}
