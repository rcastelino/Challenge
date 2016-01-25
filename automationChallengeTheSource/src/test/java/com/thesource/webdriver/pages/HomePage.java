package com.thesource.webdriver.pages;

import com.thesource.webdriver.BaseTest;
import com.thesource.webdriver.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

/**
 * Created by RolandC on 2016-01-23.
 * Purpose of this class is to hold methods / variables / constants related to Home Page
 */
public class HomePage extends BaseTest{

    public static final String WEBSITE_URL_THE_SCORE = "http://www.thescore.com";
    public static final String WEBSITE_DEFAULT_URL_THE_SCORE = "http://www.thescore.com/trending";
    public static final String MAIN_MENU_ICON_CLOSED_XPATH = "//div[contains(@class,'site-menu site-menu--closed')]";
    public static final String MAIN_MENU_ICON_OPEN_XPATH = "//div[contains(@class,'site-menu site-menu--open')]";
    public static final String MAIN_MENU_OPTION_EPL_SOCCER_CSS = "a[href='/epl/news']";

    /**
     * Method to launch 'theScore' website.
     * @throws Exception
     */
    public static void launchTheScoreWebsite() throws Exception {
        Logger.logAction("Launching 'theScore' website");
        launchWebSite(WEBSITE_URL_THE_SCORE);
    }

    /**
     * Method to verify if launch URL for 'theScore' is correct.
     * @throws Exception
     */
    public static void verifyLaunchURL() throws Exception {
        Logger.logAction("Checking Launch URL");
        Assert.assertEquals("Website URL should be: " + WEBSITE_DEFAULT_URL_THE_SCORE, WEBSITE_DEFAULT_URL_THE_SCORE, getPageURL());
    }

    /**
     * Method to expand Main Menu. Also verifies if it opened up the Main Menu.
     * @throws Exception
     */
    public static void expandMainMenu() throws Exception {
        Logger.logAction("Opening Main Menu");
        WebElement menuIcon = findElementByXpath(MAIN_MENU_ICON_CLOSED_XPATH);
        Assert.assertNotNull("Main Menu icon is Not found OR it is already opened", menuIcon);
        menuIcon.click();
        Assert.assertTrue("Main Menu did not open up after clicking.", isMainMenuOpen());
    }

    /**
     * Method to collapse Main Menu. Also verifies if it closed the Main Menu.
     * @throws Exception
     */
    public static void collapseMainMenu() throws Exception {
        Logger.logAction("Closing Main Menu");
        WebElement menuIcon = findElementByXpath(MAIN_MENU_ICON_OPEN_XPATH);
        Assert.assertNotNull("Main Menu icon is Not found OR it is already closed", menuIcon);
        menuIcon.click();
        Assert.assertTrue("Main Menu did not close up after clicking.", !isMainMenuOpen());
    }

    /**
     * Method that can be used to check if Main Menu is open
     * @return true if open else false
     * @throws Exception
     */
    public static boolean isMainMenuOpen() throws Exception{
        Logger.logAction("Checking if main menu is open");
        return isElementEnabledByXpath(MAIN_MENU_ICON_OPEN_XPATH);
    }

}
