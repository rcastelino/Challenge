package com.thesource.webdriver.pages;

import com.thesource.webdriver.BaseTest;
import com.thesource.webdriver.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

/**
 * Created by RolandC on 2016-01-23.
 * Purpose of this class is to hold methods / variables / constants related to Player Details Page
 */
public class PlayerPage extends BaseTest {

    public static final String PLAYER_NAME_CSS = "div.player-name.txt-primary.font-name";
    public static final String PLAYER_HEIGHT_CSS = "span.formatted-height-weight.info-segment-data";
    public static final String PLAYER_BIRTHDATE_CSS = "span.formatted-birthdate.info-segment-data";

    /**
     * Method to get the Name of Player displayed in Player page.
     * @return String - name
     * @throws Exception
     */
    public static String getPlayerNameFromPage() throws Exception{
        Logger.logAction("Getting name from Player Page");
        waitForElementToBeClickableByCSSSelector(PLAYER_NAME_CSS);
        WebElement playerNameElement = findElementByCSSSelector(PLAYER_NAME_CSS);
        Assert.assertNotNull("Player Page is not launched", playerNameElement);

        String name = playerNameElement.getText();
        Logger.logComment("Player Displayed: " + name);
        return name;
    }

    /**
     * Method to check if selected player and displayed plaer are same.
     * Note - We compare only the last names at the moment, since the format of names on both screens is different.
     * @param playerNameSelected - expected player.
     * @return true if there is a match else false
     * @throws Exception
     */
    public static boolean isCorrectPlayerSelected(String playerNameSelected) throws Exception{
        Logger.logAction("Check to see if player names match");
        String playerNameDisplayed = getPlayerNameFromPage();
        return playerNameDisplayed.split(" ")[1].equals(playerNameSelected.split(" ")[1]);
    }

    /**
     * Method to get Height of player selected
     * @return string - height as displayed on website
     * @throws Exception
     */
    public static String getPlayerHeight() throws Exception{
        Logger.logAction("Get player height");
        waitForElementToBeClickableByCSSSelector(PLAYER_HEIGHT_CSS);
        WebElement playerHeightElement = findElementByCSSSelector(PLAYER_HEIGHT_CSS);
        Assert.assertNotNull("Player height element is not found", playerHeightElement);
        return playerHeightElement.getText().split(" /")[0];


    }

    /**
     * Method to get BirthDate of player selected
     * @return string - birthdate as displayed on website
     * @throws Exception
     */
    public static String getPlayerBirthDate() throws Exception{
        Logger.logAction("Get player height");
        waitForElementToBeClickableByCSSSelector(PLAYER_BIRTHDATE_CSS);
        WebElement playerBirthDateElement = findElementByCSSSelector(PLAYER_BIRTHDATE_CSS);
        Assert.assertNotNull("Player height element is not found", playerBirthDateElement);
        return playerBirthDateElement.getText();


    }

}
