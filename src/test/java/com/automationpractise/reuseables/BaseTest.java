package com.automationpractise.reuseables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public WebDriver driver;
    public String username;
    public String password;
    public String name;

    public WebDriver launchBrowser(String browserType) throws Exception {
        WebDriver driver = null;
        if(browserType.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", EnvironmentConstants.ChromeBinaryPath);
            driver = new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", EnvironmentConstants.FirefoxBinaryPath);
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", EnvironmentConstants.EdgeBinaryPath);
            driver = new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", EnvironmentConstants.InternetExplorerBinaryPath);
            driver = new InternetExplorerDriver();
        } else {
            throw new Exception("Unsupported Browser Type");
        }
        driver.manage().timeouts().pageLoadTimeout(PropertiesLoader.getLongWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(PropertiesLoader.getLongWait(), TimeUnit.SECONDS);
        if(PropertiesLoader.isRunMaximize()){
            driver.manage().window().maximize();
        }

        return driver;
    }

    public void closeCurrentBrowser(WebDriver driver){
        driver.close(); //close current browser
    }

    public void closeAllBrowser(WebDriver driver){
        driver.quit(); //close all browsers
    }

    @BeforeMethod
    public void invokeBrowsers() throws Exception {
        driver = launchBrowser(PropertiesLoader.getBrowserName());
        this.username = "EnterValidUsername";
        this.password = "EnterValidPassword";
        this.name = "Anthony Nolan";

    }

    @AfterMethod(alwaysRun = true)
    public void afterEveryTest() throws Exception {
        closeCurrentBrowser(driver);

    }

    @BeforeSuite
    public void beforeAnythingElse() throws FileNotFoundException{
        PropertiesLoader.initializeConfigurations();
    }

}
