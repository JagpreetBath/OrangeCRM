package com.automationpractise.pages;

import com.automationpractise.reuseables.BasePage;
import org.openqa.selenium.WebDriver;

public class DirectoryPage extends BasePage {

        WebDriver driver;

        DirectoryPage (WebDriver driver){
            this.driver = driver;
        }

        public boolean isDirectoryDisplayed() throws Exception {
            return isDisplayed(driver,"Directory.text_PageHeading" );
        }

        public DirectoryPage selectJobTitle() throws Exception{
            selectBy(driver, "Directory.dd_JobTitle","value","13");
            return this;
        }

        public DirectoryPage selectLocation() throws Exception{
            selectBy(driver, "Directory.dd_Location","value","3,-1");
            return this;
        }

        public DirectoryPage enterName(String Name) throws Exception{
            typeInto(driver, "Directory.tbx_Name", Name);
            return this;
        }

        public DirectoryPage clickOnSearch() throws Exception{
            clickOn(driver, "Directory.btn_Search");
            return this;
        }

        public boolean isNameDisplayed() throws Exception {
            return isDisplayed(driver,"Directory.txt_ResultName" );
        }

        public DirectoryPage clickOnWelcome() throws Exception{
            clickOn(driver, "Dashboard.message_Welcome");
            return this;
        }

        public LoginPage clickOnLogout() throws Exception{
            clickOn(driver, "btn_Logout");
            return new LoginPage(driver);
        }

    }

