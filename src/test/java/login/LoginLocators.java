package login;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginLocators {

    private Page page;
    private Locator loginEmailid;
    private Locator loginPassword;
    private Locator loginButton;
    private Locator actualErrorToast;
    private static Locator loginErrorText;

    public LoginLocators(Page page) {
        this.page = page;
        this.loginEmailid = page.locator("//input[@id='username']");
        this.loginPassword = page.locator("//input[@id='password']");
        this.loginButton = page.locator("//button[@type='submit']");
        this.loginErrorText = page.locator("//span[contains(@class, 'text-red-700')]");
    }

    public void enterPhoneNumber(String email , String password) {
        loginEmailid.fill(email);
        System.out.println("Entered email");
        loginPassword.fill(password);
        System.out.println("Entered password");
    }

    public void clickLogin() {
        loginButton.click();
    }

   public String getErrorText() {
        return loginErrorText.textContent();
    }





}

