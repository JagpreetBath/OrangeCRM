package com.automationpractise.reuseables;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesLoader {

    private static Properties propertiesObj;

    private static String Browser;
    private static String RunOn;
    private static Boolean RunMaximize;
    private static boolean CaptureScreenshots;
    private static String CaptureScreenshotsFor;
    private static int ShortWait;
    private static int MediumWait;
    private static int LongWait;
    private static String ApplicationURL;

    public static String getBrowserName(){
        return Browser;
    }

    public static String getRunOn(){
        return RunOn;
    }

    public static Boolean isRunMaximize(){
        return RunMaximize;
    }

    public static boolean isCaptureScreenshots(){
        return CaptureScreenshots;
    }

    public static String getCaptureScreenshotsFor(){
        return CaptureScreenshotsFor;
    }

    public static int getShortWait(){
        return ShortWait;
    }

    public static int getMediumWait(){
        return MediumWait;
    }

    public static int getLongWait(){
        return LongWait;
    }

    public static String getApplicationURL(){
        return ApplicationURL;
    }

    public static void loadProperties(String fullFilePath) throws FileNotFoundException {
       try {
           propertiesObj = new Properties();
           propertiesObj.load(
                   new FileInputStream(
                           new File(fullFilePath)));

       } catch (Exception e){
           System.out.println("Unable to read property file. Please check the location of the file");
       }
    }

    public static void loadProperties() throws FileNotFoundException {
        try {
            propertiesObj = new Properties();
            propertiesObj.load(
                    new FileInputStream(
                            new File(
                                    System.getProperty("user.dir") +
                                            "/src/test/resources/configs/uat-config.properties")));

        } catch (Exception e){
            System.out.println("Unable to read property file. Please check the location of the file");
        }
    }

    public static String getProperty(String propertyName){
        return propertiesObj.getProperty(propertyName);
    }

    public static void initializeConfigurations() throws FileNotFoundException{
        loadProperties();
        Browser = getProperty("Browser");
        RunOn = getProperty("RunOn");
        CaptureScreenshots = Boolean.parseBoolean(getProperty("CaptureScreenshots"));
        CaptureScreenshotsFor = getProperty("CaptureScreenshotsFor");
        ShortWait = Integer.parseInt(getProperty("ShortWait"));
        MediumWait = Integer.parseInt(getProperty("MediumWait"));
        LongWait = Integer.parseInt(getProperty("LongWait"));
        ApplicationURL = getProperty("ApplicationURL");
        RunMaximize =Boolean.parseBoolean(getProperty("RunMaximize"));
    }


}
