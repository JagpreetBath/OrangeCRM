package com.automationpractise.A3;

import com.automationpractise.pages.DashboardPage;
import com.automationpractise.reuseables.BaseAssertion;
import com.automationpractise.pages.LoginPage;
import com.automationpractise.pages.MyInfoPage;
import com.automationpractise.reuseables.BaseTest;
import org.testng.annotations.Test;

public class OrangeCRM_PersonalInfoValidation extends BaseTest {

    @Test
    public void personalInfoValidation() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.launchAutomationPractiseApp();
        loginPage.enterUsername(username).
                enterPassword(password);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        boolean welcomeMessage = dashboardPage.isWelcomeDisplayed();
        BaseAssertion.shouldBeTrue(welcomeMessage);
        Thread.sleep(3000);

        MyInfoPage myInfoPage = dashboardPage.clickOnMyInfo();
        boolean myInfoHeading = myInfoPage.isMyInfoDisplayed();
        BaseAssertion.shouldBeTrue(myInfoHeading);
        String firstName = myInfoPage.getFirstName();
        BaseAssertion.shouldBeEqual(firstName, "Rahul");
        String lastName = myInfoPage.getLastName();
        BaseAssertion.shouldBeEqual(lastName, "Verma");
        myInfoPage.clickOnWelcome();
        myInfoPage.clickOnLogout();
        boolean loginButton =loginPage.isLoginDisplayed();
        BaseAssertion.shouldBeTrue(loginButton);

    }
}
