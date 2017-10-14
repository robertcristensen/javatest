package com.selenium.test.junit.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.nio.file.Path;

public class TestsRunner {
    public static void main(String[] args) {
  /*      Result result = JUnitCore.runClasses(GooglePageTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) System.out.println("Test finished Successfully");
        System.out.println("Total tests completed: " + result.getRunCount());*/
        String hub_ep = System.getenv("SELENIUM_HUB_EP");
        System.out.println("http://" + hub_ep + "/wd/hub");

    }
}

