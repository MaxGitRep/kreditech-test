package com.kreditech.uipack.helpers;

import static org.testng.Assert.assertTrue;

/**
 * Created by pc on 31.07.2017.
 */
public class Assertions {

    public static void assertEquals(String actual, String expected, String massage) {
        assertTrue(expected.equals(actual),
                massage + " is not expected. \nExpected: " + expected + "\nActual  : " + actual + "\n");
    }

    public static void assertContains(String actual, String expected, String massage) {
        assertTrue(actual.contains(expected),
                massage + " is not expected. \nExpected: " + expected + "\nActual  : " + actual + "\n");
    }
}
