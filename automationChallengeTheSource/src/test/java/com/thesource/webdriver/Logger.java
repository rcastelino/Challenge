package com.thesource.webdriver;

import java.util.Date;

/**
 * Created by RolandC on 2016-01-21.
 */
public class Logger {

    private static String suffix = "- - - - - - - - - - ";
    private static String banner = "* * * * * * * * * * ";
    private static String step = "==========================================================";
    private static String warning = "#######################";

    /**
     * This method should be used at start of each test case
     * @param testName - name of test case
     */
    public static void beginTest(final String testName) {

        Date timeTestBegan = new Date();
        System.out.println(banner);
        System.out.println("Beginning test " + testName + " at " + timeTestBegan);
        System.out.println();
        System.out.println();
    }

    /**
     * This method should be used at end of each test case
     * @param testName - name of test case
     */
    public static void endTest(final String testName) {
        Date timeTestEnded = new Date();
        System.out.println();
        System.out.println();
        System.out.println("Finishing test " + testName + " at " + timeTestEnded);
        System.out.println(banner);
    }

    /**
     * This method should be used in each method or debug point.
     * @param msg - brief message associated with action
     */
    public static void logAction(final String msg) {
        System.out.println("  " + msg);
        System.out.println("  " + suffix);
    }

    /**
     * This method should be used to highlight any important notes or comment.
     * @param msg - comment that we want to highlight
     */
    public static void logComment(final String msg) {
        System.out.println("        -> " + msg);
        System.out.println("  " + suffix);
    }

    /**
     * This method should be used at beginning of each test step.
     * @param stepMsg - step description
     */
    public static void logStep(final String stepMsg) {
        System.out.println(step);
        System.out.println(stepMsg);
        System.out.println(step);

    }

    /**
     * This method should be used to highlight any warnings
     * @param msg - warning message
     */
    public static void logWarning(final String msg) {
        System.out.println(warning);
        System.out.println("### WARNING: " + msg);
        System.out.println(warning);
    }

}
