package com.automationpractise.pages;

import com.automationpractise.reuseables.BasePage;
import com.automationpractise.reuseables.PropertiesLoader;
import org.openqa.selenium.WebDriver;

// POM(Page Object Model) it says for each corresponding application page, you need to a java class having same name
// each method should return the current page object or next page object;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage launchAutomationPractiseApp(){
        driver.get(PropertiesLoader.getApplicationURL());
        return this;
    }

    public LoginPage enterUsername(String username)throws Exception{
        typeInto(driver, "Login.tbx_Username", username);
        return this;
    }

    public LoginPage enterPassword(String password)throws Exception{
        typeInto(driver, "Login.tbx_Password", password);
        return this;
    }

    public DashboardPage clickLoginButton() throws Exception{
        clickOn(driver, "Login.btn_Login");
        return new DashboardPage(driver);
    }

    public boolean isLoginDisplayed() throws Exception {
        return isDisplayed(driver,"Login.btn_Login");
    }

}
