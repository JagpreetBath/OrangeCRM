package com.automationpractise.reuseables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Set;

public class BasePage {

    public static WebElement findElement(WebDriver driver, String elementName) throws Exception {
        PropertiesLoader.loadProperties(
                System.getProperty("user.dir") + "/src/test/resources/ObjectRepository/OR.properties");
        String elementFromOR = PropertiesLoader.getProperty(elementName);
        String how = elementFromOR.split(":")[0];
        String value = elementFromOR.split(":")[1];
        return findElementBy(driver, how, value);
    }

    public static WebElement findElementBy(WebDriver driver, String how, String value) throws Exception{
        WebElement element = null;
        try {
            switch (how) {
                case "id":
                    element = driver.findElement(By.id(value));
                    break;
                case "name":
                    element = driver.findElement(By.name(value));
                    break;
                case "class":
                    element = driver.findElement(By.className(value));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(value));
                    break;
                case "lt":
                    element = driver.findElement(By.linkText(value));
                    break;
                case "plt":
                    element = driver.findElement(By.partialLinkText(value));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(value));
                    break;
                case "tag":
                    element = driver.findElement(By.tagName(value));
                    break;
                default:
                    throw new Exception("Invalid Locator type provided");
                }
            } catch (Exception e) {
                System.out.println("Element not found, Full Exception details: "+ e );
                throw e;
            }
            return element;
        }

    public static void clickOn(WebDriver driver, String clickOn) throws Exception{
        try {
            WebElement element = findElement(driver, clickOn);
            element.click();
        } catch (Exception e){
            System.out.println("Unable to click on:" + clickOn);
            throw e;
        }
    }

    public static void typeInto(WebDriver driver, String typeInto, String valueToType) throws Exception{
        try {
            WebElement element = findElement(driver, typeInto);
            element.clear();
            element.click();
            element.sendKeys(valueToType);
        } catch (Exception e){
            System.out.println("Unable to type into [ " + typeInto + " ]");
            throw e;
        }
    }

    public static boolean isDisplayed(WebDriver driver, String elementToCheck) throws  Exception{
        try {
            WebElement element = findElement(driver, elementToCheck);
            return element.isDisplayed();
        } catch (Exception e){
            System.out.println("Unable to verify condition \" is displayed \" for element :" + elementToCheck);
            throw e;
        }
    }

    public static String getAttributeValue(WebDriver driver, String getAttributeValue) throws Exception {
        try {
            WebElement element = findElement(driver, getAttributeValue);
            String attributeValue = element.getAttribute("value");
            return attributeValue;
        } catch (Exception e){
            System.out.println("Unable to get text [ " + getAttributeValue + " ]");
            throw e;
        }
    }

    public static void switchToWindows(int index, WebDriver driver){
        try {
            Set<String> sessionIDs = driver.getWindowHandles(); // Step 1 get session IDs
            System.out.println(sessionIDs);
            ArrayList<String> windows = new ArrayList<>(sessionIDs); // Step 2 convert set into arraylist
            driver.switchTo().window(windows.get(index));
        } catch (Exception e){
        System.out.println("Unable to switch to Window");
        throw e;
        }
    }

    public static void switchToLastWindow(WebDriver driver){
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(driver.getWindowHandles().size() - 1));
        }catch (Exception e){
            System.out.println("Unable to switch to Window");
            throw e;
        }
    }

    public static void switchToOriginalWindow(WebDriver driver){
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(0));
        }catch (Exception e){
            System.out.println("Unable to switch to Window");
            throw e;
        }
    }

    public static void switchToSecondLastWindow(WebDriver driver){
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(driver.getWindowHandles().size() - 2));
        } catch (Exception e){
            System.out.println("Unable to switch to Window");
            throw e;
        }
    }

    public static void switchToSecondWindow(WebDriver driver){
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(1));
        } catch (Exception e){
            System.out.println("Unable to switch to Window");
            throw e;
        }
    }

    public static void switchToThirdWindow(WebDriver driver) {
        try{
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(2));
        } catch (Exception e){
            System.out.println("Unable to switch to Window");
            throw e;
        }
    }

    public static void switchToAlertAndAccept(WebDriver driver){
        try{
            driver.switchTo().alert().accept();
        } catch (Exception e){
            System.out.println("Unable to switch to Alert and Accept ");
            throw e;
        }
    }

    public static void switchToAlertAndDismiss(WebDriver driver){
        try{
            driver.switchTo().alert().dismiss();
        } catch (Exception e){
            System.out.println("Unable to switch to Alert and Dismiss");
            throw e;
        }
    }

    public static void switchToAlertAndSendValue(WebDriver driver, String text){
        try{
            driver.switchTo().alert().sendKeys(text);
            switchToAlertAndAccept(driver);
        } catch (Exception e){
            System.out.println("Unable to switch to Alert and Dismiss");
            throw e;
        }
    }

    public static void switchToFrame(String frame, WebDriver driver){
        try {
            driver.switchTo().frame(frame);
        }catch (Exception e){
            System.out.println("Unable to switch to Frame");
            throw e;
        }
    }

    public static void switchToFrame(WebElement element, WebDriver driver){
        try {
            driver.switchTo().frame(element);
        } catch (Exception e) {
            System.out.println("Unable to switch to Frame");
            throw e;
        }
    }

    public static void switchToMainPageFromFrame(WebDriver driver){
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("Unable to switch to Main Page");
            throw e;
        }
    }

    public static void scrollDown(WebDriver driver){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        } catch (Exception e) {
            System.out.println("Unable to scroll the page");
            throw e;
        }
    }

    public static void scrollUp(WebDriver driver){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        } catch (Exception e) {
            System.out.println("Unable to scroll the page");
            throw e;
        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll the page");
            throw e;
        }
    }

    public static void selectBy(WebDriver driver,String selectBy, String mode, String option) throws Exception {
        try {
            WebElement element = findElement(driver, selectBy);
            Select ddlist = new Select(element);
            if (mode.equalsIgnoreCase("Value")) {
                ddlist.selectByValue(option);
            } else if (mode.equalsIgnoreCase("Text")) {
                ddlist.selectByVisibleText(option);
            } else if (mode.equalsIgnoreCase("Index")) {
                ddlist.selectByIndex(Integer.parseInt(option));
            }
        } catch (Exception e) {
            System.out.println("Unable to Select :" + selectBy);
            throw e;
        }
    }

}
