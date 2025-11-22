package dashboard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.beforeMethod.SetupBrowser;
import com.microsoft.playwright.Locator;

import login.LoginLocators;
import login.LoginTest;

public class DashboardTest extends SetupBrowser{
   // LoginTest login = new LoginTest();
    private DashboardLocators dash;
    private LoginLocators login;
    
 @BeforeMethod
    public void init() {
        login = new LoginLocators(page); // Now page is initialized
        dash = new DashboardLocators(page);
    }

@Test
public void dashboardView() throws InterruptedException{
    login.enterPhoneNumber("admin","admin123");
    login.clickLogin();
    dash.clickActiveUsers();
    System.out.println("Clicked active users tab");
    Thread.sleep(3000);
}

}
