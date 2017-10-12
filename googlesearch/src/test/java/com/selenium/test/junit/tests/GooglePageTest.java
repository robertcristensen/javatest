package com.selenium.test.junit.tests;

import com.selenium.test.pages.GooglePage;
import com.selenium.test.pages.GoogleSearchResultPage;
import com.selenium.test.pages.YouTubePage;
import com.selenium.test.pages.YouTubeSearchResultsPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GooglePageTest {

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void testSearch() {
        String toSearch = "miratech";
        int ExpectedNumberOfLinks = 10;
        GooglePage googlePage = new GooglePage();
        googlePage.inputText(toSearch);
        GoogleSearchResultPage  resultsPage = googlePage.doSearch();
   //     System.out.println(resultsPage.numberOfLinks());
        Assert.assertEquals(ExpectedNumberOfLinks,resultsPage.numberOfLinks());
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}