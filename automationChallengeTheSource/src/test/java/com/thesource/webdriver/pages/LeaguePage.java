package com.thesource.webdriver.pages;

import com.thesource.webdriver.BaseTest;
import com.thesource.webdriver.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by RolandC on 2016-01-23.
 * Purpose of this class is to hold methods / variables / constants related to League Details Page
 */
public class LeaguePage extends BaseTest {

    public static final String LEAGUE_EPL_SOCCER_CSS = "a[href='/epl/news']";
    public static final String LEAGUE_LEADERS_TAB_CSS = "a[href*='leaders']";
    public static final String LEAGUE_EPL_LEADERS_TAB_CSS = "a[href='/epl/leaders']";
    public static final String LEAGUE_PLAYERS_CSS = "a[href*='players']";

    /**
     * Method to select EPL Soccer League
     * @throws Exception - if EPL League not found
     */
    public static void clickLeagueEPL() throws Exception{
        Logger.logAction("Selecting EPL Soccer");
        WebElement eplElement = findElementByCSSSelector(LEAGUE_EPL_SOCCER_CSS);
        Assert.assertNotNull("EPL soccer link not available", eplElement);
        eplElement.click();
    }


    /**
     * Method to select Leaders tab for whichever League page we are in.
     * @throws Exception
     */
    public static void clickLeadersTab() throws Exception{
        Logger.logAction("Selecting Leaders");
        WebElement leadersElement = findElementByCSSSelector(LEAGUE_LEADERS_TAB_CSS);
        Assert.assertNotNull("Leaders link not available", leadersElement);
        leadersElement.click();
    }

    /**
     * Method to scroll and select a Random Player from
     * @return Name of player that is selected
     * @throws Exception
     */
    public static String selectRandomPlayerFromLeadersList() throws Exception{
        Logger.logAction("Selecting a random player from Leaders");
        String playerName;

        List<WebElement> playersList = driver.findElements(By.cssSelector(LEAGUE_PLAYERS_CSS));
        int playerIndex = getRandomIndex(playersList.size());
        playerName = playersList.get(playerIndex).getText().split("\\r?\\n")[1];

        // TODO: need to find a better way than 'playerIndex-3' so that element is scrolled and in view
        scrollToElement(playersList.get(playerIndex - 3));

        try{
            playersList.get(playerIndex).click();
            Logger.logComment("Selecting player: " + playerName);
        } catch (Exception cannotClickElement){
            Logger.logWarning("We were unable to select the Player: " + playerName);
            Assert.fail("Failing since we cannot click on player element.");
        }

        return playerName;
    }
}
