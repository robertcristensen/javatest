package com.selenium.test.webtestsbase;

import com.selenium.test.configuration.TestsConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sidelnikov Mikhail on 18.09.14.
 * Base class for web tests. It contains web driver {@link org.openqa.selenium.WebDriver} instance, used in all tests.
 * All communications with driver should be done through this class
 */
public class WebDriverFactory {
    private static final long IMPLICIT_WAIT_TIMEOUT = 5;
    private static WebDriver driver;

    /**
     * Getting of pre-configured {@link org.openqa.selenium.WebDriver} instance.
     * Please use this method only after call {@link #startBrowser(boolean) startBrowser} method
     *
     * @return webdriver object, or throw IllegalStateException, if driver has not been initialized
     */
    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }

    private static URL getUrl() {
        try {
         //     String u = "http://18.216.8.56:4446/wd/hub";
         //     String u = "http://172.18.0.2:4444/wd/hub";

         //   String u = "http://127.0.0.1:4446/wd/hub";
            String u = "http://" + System.getenv("SELENIUM_HUB_EP") + "/wd/hub";
            URL url = new URL(u);
            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Main method of class - it initialize driver and starts browser.
     *
     * @param isLocal - is tests will be started local or not
     */
    public static void startBrowser(boolean isLocal) {
        if (driver == null) {
            Browser browser = TestsConfig.getConfig().getBrowser();
            if (!isLocal) {
                driver = new RemoteWebDriver(CapabilitiesGenerator.getDefaultCapabilities(browser));
            } else {
                switch (browser) {
                    case FIREFOX:
                       // System.setProperty("webdriver.gecko.driver","E:\\Software\\geckodriver.exe");
                        driver = new RemoteWebDriver(getUrl(), CapabilitiesGenerator.getDefaultCapabilities(Browser.FIREFOX));
                      //  driver = new FirefoxDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.FIREFOX));
                        break;
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");
                        driver = new ChromeDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.CHROME));
                        break;
                    case IE10:
                        driver = new InternetExplorerDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.IE10));
                        break;
                    case SAFARI:
                        driver = new SafariDriver(CapabilitiesGenerator.getDefaultCapabilities(Browser.SAFARI));
                        break;
                    default:
                        throw new IllegalStateException("Unsupported browser type");
                }
            }
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }
    }

    /**
     * Finishes browser
     */
    public static void finishBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Method for screenshot taking. It is empty now, because you could save your screenshot as you want.
     * This method calls in tests listeners on test fail
     */
    public static void takeScreenShot() {
        System.out.println("ScreenShot method called");
    }

}
