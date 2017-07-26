package helpers;

import models.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestException;

import java.util.concurrent.TimeUnit;

/**
 * Created by Perets on 26.07.2017.
 */
public class Webdriver
{
    public static WebDriver driver;
    private static int WEBDRIVER_WAIT = 30;

    public static Webdriver wd = new Webdriver();

    public WebDriver runLocalBrowser(Browsers p_browserName) {
        try {
            driver = getBrowserInstance(p_browserName);
            driver.manage().timeouts().implicitlyWait(WEBDRIVER_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(WEBDRIVER_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(WEBDRIVER_WAIT, TimeUnit.SECONDS);
            return driver;

        } catch (Exception p_ex) {
            throw new TestException("Unable to start browser due to " + p_ex.toString() + " p_browserName = " + p_browserName);
        }
    }

    public WebDriver getBrowserInstance(Browsers p_browser) {
        switch (p_browser) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new TestException("Browser is not supported => " + p_browser);
        }

    }
}
