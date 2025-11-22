package test;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class SamplePlaywrightTest {

    @Test
    public void testInAllBrowsers() throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {

            // Loop through all 3 browser types
            for (BrowserType browserType : new BrowserType[]{
                    playwright.chromium(),
                  //  playwright.firefox(),
                   // playwright.webkit()
            }) {
                Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
                Page page = browser.newPage();
                page.navigate("https://xplor-erp-dev.netlify.app/");
                Thread.sleep(4000);
                System.out.println("Browser: " + browserType.name() + " | Title: " + page.title());
                Thread.sleep(5000);
                Locator phoneNumberField = page.locator("//input[@name='phoneNumber']");
               phoneNumberField.click();
               System.out.println("Clicked");
                phoneNumberField.fill("9605336615");
                System.out.println("Entered");
                Thread.sleep(3000);

            }

        }
    }
}
