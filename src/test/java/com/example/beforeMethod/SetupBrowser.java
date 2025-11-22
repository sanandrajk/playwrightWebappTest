package com.example.beforeMethod;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SetupBrowser {
    //https://xplor-erp-dev.netlify.app/
    //https://execution-internal-dashboard-test.netlify.app/login
   protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://execution-internal-dashboard-test.netlify.app/login");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Driver is closing");
        browser.close();
        playwright.close();
    }
}
