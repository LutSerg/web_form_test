package com.demoqa.webform.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemProperties")
public class SystemPropertiesTests {
    @Test
    void someTest1 () {
        String browser = System.getProperty("Browser");
        System.out.println(browser);
    }
    @Test
    void someTest2 () {
        System.setProperty("Browser", "Safari");
        String browser = System.getProperty("Browser");
        System.out.println(browser);
    }
    @Test
    void someTest3 () {
        String browser = System.getProperty("Browser","Firefox");
        System.out.println(browser);
    }
    @Test
    void someTest4 () {
        System.setProperty("Browser", "Opera");
        String browser = System.getProperty("Browser","Firefox");
        System.out.println(browser);
    }
    @Test
    @Tag("test5")
    void someTest5 () {

        String browser = System.getProperty("Browser","Firefox");
        String version = System.getProperty("version","95");
        String browserSize = System.getProperty("browserSize","1920x1080");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
    @Test
    void someTest6 () {
        System.out.println("I want to say " + System.getProperty("anyText"));
    }
}
