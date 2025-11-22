package dashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DashboardLocators {
    
    private Page page;
    public Locator dashboardOwnerMetrics;
    public Locator dashboardTotalUsers;
    public Locator dashboardActiveUsers;
    public Locator dashboardCancelledUsers;
    public Locator dashboardChurnedUsers;

public DashboardLocators(Page page){
    this.dashboardOwnerMetrics = page.getByText("Owner Metrics");
    this.dashboardTotalUsers = page.getByText("Total Users");
    this.dashboardActiveUsers = page.getByText("Active Users");
    this.dashboardCancelledUsers = page.getByText("Autopay Cancelled");
    this.dashboardChurnedUsers = page.getByText("Churned Users");
}

public String dashboardText(){
    return dashboardOwnerMetrics.textContent();
}

public void clickTotalUser(){
dashboardTotalUsers.click();
}

public void clickActiveUsers(){
    dashboardActiveUsers.click();
}

public void clickCancelledUsers(){
    dashboardCancelledUsers.click();
}

public void clickChurnedUsers(){
    dashboardChurnedUsers.click();
}

}
