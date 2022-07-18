package com.automationpractise.A3;

import com.automationpractise.pages.DashboardPage;
import com.automationpractise.reuseables.BaseAssertion;
import com.automationpractise.pages.DirectoryPage;
import com.automationpractise.pages.LoginPage;
import com.automationpractise.reuseables.BaseTest;
import org.testng.annotations.Test;

public class OrangeCRM_DirectorySearch extends BaseTest {

    @Test
    public void directorySearch() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchAutomationPractiseApp();
        loginPage.enterUsername(username).
                enterPassword(password);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        boolean welcomeMessage = dashboardPage.isWelcomeDisplayed();
        BaseAssertion.shouldBeTrue(welcomeMessage);
        Thread.sleep(3000);
        DirectoryPage directoryPage = dashboardPage.clickOnDirectory();
        boolean directoryHeading = directoryPage.isDirectoryDisplayed();
        BaseAssertion.shouldBeTrue(directoryHeading);
        directoryPage.selectJobTitle().
                selectLocation().
                enterName(name).
                clickOnSearch();
        boolean searchName = directoryPage.isNameDisplayed();
        BaseAssertion.shouldBeTrue(searchName);
        directoryPage.clickOnWelcome();
        directoryPage.clickOnLogout();
        boolean loginButton =loginPage.isLoginDisplayed();
        BaseAssertion.shouldBeTrue(loginButton);
    }

}
