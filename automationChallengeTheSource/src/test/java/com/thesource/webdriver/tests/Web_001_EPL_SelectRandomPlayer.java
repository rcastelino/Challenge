package com.thesource.webdriver.tests;

import com.thesource.webdriver.BaseTest;
import com.thesource.webdriver.CommonData;
import com.thesource.webdriver.Logger;
import com.thesource.webdriver.pages.HomePage;
import com.thesource.webdriver.pages.LeaguePage;
import com.thesource.webdriver.pages.PlayerPage;
import org.junit.Assert;
import org.junit.Test;

public class Web_001_EPL_SelectRandomPlayer extends BaseTest {

    @Test
    public void testSelectRandomPlayer() throws Exception {

        Logger.beginTest("Web_001_EPL_SelectRandomPlayer - Verify Height and Birthdate format of player from EPL Soccer");

        Logger.logStep("1. Navigate to http://www.thescore.com");
        HomePage.launchTheScoreWebsite();

        Logger.logStep("2. Verify the URL is correct");
        HomePage.verifyLaunchURL();

        Logger.logStep("3. Navigate to the main menu button and click to open it up");
        HomePage.expandMainMenu();

        Logger.logStep("4. Click on EPL Soccer");
        LeaguePage.clickLeagueEPL();

        Logger.logStep("5. Click on Leaders");
        LeaguePage.clickLeadersTab();
        Assert.assertTrue("Leaders tab of EPL league is Not launched", isElementEnabledByCSS(LeaguePage.LEAGUE_EPL_LEADERS_TAB_CSS));

        Logger.logStep("6. Click on a random player");
        String player = LeaguePage.selectRandomPlayerFromLeadersList();
        Assert.assertTrue("Player Page for: '" + player + "' is not launched", PlayerPage.isCorrectPlayerSelected(player));

        Logger.logStep("7. Verify that height and birthdate display correctly");
        String height = PlayerPage.getPlayerHeight();
        String birthdate = PlayerPage.getPlayerBirthDate();
        Logger.logComment("Player - " + player);
        Logger.logComment("Height - " + height);
        Logger.logComment("BirthDate - " + birthdate);

        Assert.assertTrue("Height is Not displayed correctly", (height.matches(CommonData.PLAYER_HEIGHT_REGEX_1) ||
                height.matches(CommonData.PLAYER_HEIGHT_REGEX_2)));

        Assert.assertTrue("BirthDate is Not displayed correctly", birthdate.matches(CommonData.PLAYER_BIRTHDATE_REGEX));

        Logger.endTest("Web_001_EPL_SelectRandomPlayer - Verify Height and Birthdate format of player from EPL Soccer");

    }
}
