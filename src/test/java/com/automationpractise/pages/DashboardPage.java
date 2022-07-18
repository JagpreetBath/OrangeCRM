package com.automationpractise.pages;

import com.automationpractise.reuseables.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    WebDriver driver;

    DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isWelcomeDisplayed() throws Exception {
        return isDisplayed(driver,"Dashboard.message_Welcome" );
    }

    public DirectoryPage clickOnDirectory() throws Exception{
        clickOn(driver, "menu_Directory");
        return new DirectoryPage(driver);
    }

    public MyInfoPage clickOnMyInfo() throws Exception{
        clickOn(driver, "menu_MyInfo");
        return new MyInfoPage(driver);
    }

}
