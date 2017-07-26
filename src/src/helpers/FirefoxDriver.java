package helpers;

import org.openqa.selenium.WebDriver;

/**
 * Created by Perets on 26.07.2017.
 */
public class FirefoxDriver extends Webdriver
{
    public static class WebDriverHolder {
        public static final WebDriver DRIVER = new org.openqa.selenium.firefox.FirefoxDriver();
    }

    public static WebDriver getInstance() {
        return WebDriverHolder.DRIVER;
    }
}