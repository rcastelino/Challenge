package com.thesource.webdriver;

/**
 * Created by RolandC on 2016-01-21.
 */
public class CommonData {

    // Default Timers
    public static final long WAIT_TIME_1S = 1;
    public static final long WAIT_TIME_5S = 5;
    public static final long WAIT_TIME_10S = 10;
    public static final long WAIT_TIME_30S = 30;


    //Regular Expressions
    public static final String PLAYER_HEIGHT_REGEX_1 = "\\d{1}' \\d{1}\"";
    public static final String PLAYER_HEIGHT_REGEX_2 = "\\d{1}' \\d{2}\"";
    public static final String PLAYER_WEIGHT_REGEX = "\\d{3} lbs";
    public static final String PLAYER_BIRTHDATE_REGEX = "\\d{4}-\\d{2}-\\d{2} \\(\\d{2}\\)";
}
