package com.selenium.test.testng.tests;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class google_miratech {

    @Test
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.gecko.driver","E:\\Software\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
     //   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //     DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //     capabilities.setCapability("marionette", true);
        //comment the above 2 lines and uncomment below 2 lines to use Chrome

        String baseUrl = "http://google.com";
        String expectedTitle = "Google";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        Assert.assertEquals(expectedTitle, actualTitle);
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        // Locate Search element
        WebElement searchForm = driver.findElement(By.name("q"));
        searchForm.sendKeys("miratech");
        searchForm.submit();
        WebDriverWait wait =  new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("_Rm")));
       // List<WebElement> results = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));
        List<WebElement> results = driver.findElements(By.className("_Rm"));
        System.out.println(results.size());
        //close Firefox
        driver.close();

    }

}