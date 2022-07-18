package com.automationpractise.reuseables;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BaseAssertion {

    public static void shouldBeEqual(String str1, String str2){
        Assert.assertEquals(str1, str2, "Mismatch of values in Value[ " + str1 + " ] and Value2 [ " + str2 + " ]");
    }

    public static void shouldNotBeEqual(String str1, String str2){
        Assert.assertNotEquals(str1, str2, "Mismatch of values in Value[ " + str1 + " ] and Value2 [ " + str2 + " ]");
    }

    public static void shouldBeTrue(boolean condition) {

        Assert.assertTrue(condition, "Condition not true");
    }
    public static void shouldBeFalse(boolean condition) {

        Assert.assertTrue(condition, "Condition not false");
    }
    public static void shouldBeVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Condition not true");
    }
}
