package com.thesource.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Created by RolandC on 2016-01-21.
 */
public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() throws Exception {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void teardown() throws Exception {
        driver.close();
        driver.quit();
    }


    /**
     * Method to launch a website.
     * @param websiteURL - link that we want to open in browser
     * @throws Exception - if unable to launch site
     */
    public static void launchWebSite(String websiteURL) throws Exception {
        driver.navigate().to(websiteURL);
    }

    /**
     * Method to get URL of page on screen
     * @return URL of current page
     * @throws Exception - if cannot get URL
     */
    public static String getPageURL() throws Exception {
        Logger.logAction("URL is: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }


    /**
     * Method to find an element on page by xpath
     * @param elementXpath - xpath
     * @return - returns element if found else returns null
     */
    public static WebElement findElementByXpath(String elementXpath){
        try{
            waitForElementToBeClickableByXpath(elementXpath);
            return driver.findElement(By.xpath(elementXpath));
        } catch(Exception noElementFound){
            Logger.logWarning("Element with Xpath - " + elementXpath + " - not found");
            return null;
        }
    }

    /**
     * Method to find an element on page by xpath
     * @param elementCSS - CSS Selector string
     * @return - returns element if found else returns null
     */
    public static WebElement findElementByCSSSelector(String elementCSS){
        try{
            waitForElementToBeClickableByCSSSelector(elementCSS);
            return driver.findElement(By.cssSelector(elementCSS));
        } catch(Exception noElementFound){
            Logger.logWarning("Element with Xpath - " + elementCSS + " - not found");
            return null;
        }
    }

    /**
     * Method to check if an element is enabled by xpath
     * @param elementXpath - xpath
     * @return true if enabled. false if not enabled or not available
     */
    public static boolean isElementEnabledByXpath(String elementXpath){
        try{
            waitForElementToBeClickableByXpath(elementXpath);
            WebElement element = driver.findElement(By.xpath(elementXpath));
            return element.isEnabled();
        } catch (Exception elementNotFound){
            return false;
        }
    }

    /**
     * Method to check if an element is enabled by CSS Selector
     * @param elementCSS - CSS selector string
     * @return true if enabled. false if not enabled or not available
     */
    public static boolean isElementEnabledByCSS(String elementCSS){
        try{
            waitForElementToBeClickableByCSSSelector(elementCSS);
            WebElement element = driver.findElement(By.cssSelector(elementCSS));
            return element.isEnabled();
        } catch (Exception elementNotFound){
            return false;
        }
    }


    /**
     * Method to wait for element to be clickable. Will wait for max 10 secs
     * @param elementXpath - xpath string of element to wait for.
     */
    public static void waitForElementToBeClickableByXpath(String elementXpath) throws Exception{
        Logger.logAction("Waiting for element to display - max time in seconds - " + CommonData.WAIT_TIME_30S);
        WebDriverWait wait = new WebDriverWait(driver, CommonData.WAIT_TIME_10S);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

    /**
     * Method to wait for element to be clickable. Will wait for max 10 secs
     * @param elementCSS - css selector string of element to wait for.
     */
    public static void waitForElementToBeClickableByCSSSelector(String elementCSS) throws Exception{
        Logger.logAction("Waiting for element to display - max time in seconds - " + CommonData.WAIT_TIME_30S);
        WebDriverWait wait = new WebDriverWait(driver, CommonData.WAIT_TIME_30S);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementCSS)));
    }


    /**
     * Method to scroll to an element
     * @param element
     * @throws Exception
     */
    public static void scrollToElement(WebElement element) throws Exception{
        Logger.logAction("Scrolling to element");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    /**
     * Helper method to return a random number in range 0 to maxNum
     * @param maxNum Maximum range of random number
     * @return Random number
     */
    public static int getRandomIndex(int maxNum) throws Exception{
        Random rand = new Random();
        return rand.nextInt((maxNum));
    }

}
