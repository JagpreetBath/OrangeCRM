package com.automationpractise.pages;

import com.automationpractise.reuseables.BasePage;
import org.openqa.selenium.WebDriver;

public class MyInfoPage extends BasePage {
    WebDriver driver;

    MyInfoPage (WebDriver driver){
        this.driver = driver;
    }

    public boolean isMyInfoDisplayed() throws Exception {
        return isDisplayed(driver,"MyInfo.txt_PageHeading" );
    }

    public String getFirstName() throws Exception {
        String firstName = getAttributeValue(driver,"MyInfo.tbx_FirstName" );
        return firstName ;
    }

    public String getLastName() throws Exception {
        String lastName = getAttributeValue(driver,"MyInfo.tbx_LastName" );
        return lastName ;
    }

    public MyInfoPage clickOnWelcome() throws Exception{
        clickOn(driver, "Dashboard.message_Welcome");
        return this;
    }

    public LoginPage clickOnLogout() throws Exception{
        clickOn(driver, "btn_Logout");
        return new LoginPage(driver);
    }
}
