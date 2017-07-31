package helpers;

import models.Browsers;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static system_config.Config.config;

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
            driver.manage().window().setSize(getScreeDimesions());
            return driver;

        } catch (Exception p_ex) {
            throw new TestException("Unable to start browser due to " + p_ex.toString() + " p_browserName = " + p_browserName);
        }
    }

    public Dimension getScreeDimesions() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        return new Dimension(width, height);
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

    public void click(By p_locator) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 10 seconds for search in DOM
            Wait<WebDriver> wait = new WebDriverWait(driver, config.WEBDRIVER_WAIT);
            wait.until(ExpectedConditions.elementToBeClickable(p_locator));
            WebElement element = driver.findElement(p_locator);
            element.click();
        } catch (Exception p_ex) {
            throw new TestException("Cannot click on an element => " + p_locator.toString() + "\nReason: " + p_ex);
        }
    }

    public void selectItemInList(By p_element, String p_value) {
        try {
            WebElement webElement = wd.driver.findElement(p_element);
            Select valuesList = new Select(webElement);
            valuesList.selectByValue(p_value);
        } catch (Exception p_ex) {
            throw new TestException("selectItemInList : " + p_ex);
        }
    }

    public void selectItemInList(By p_element, int p_index) {
        try {
            WebElement webElement = wd.driver.findElement(p_element);
            Select valuesList = new Select(webElement);
            valuesList.selectByIndex(p_index);
        } catch (Exception p_ex) {
            throw new TestException("selectItemInList : " + p_ex);
        }
    }

    public void setElementText(By p_locator, String p_text) {
        try {
            WebElement element = wd.driver.findElement(p_locator);
            element.clear();
            element.sendKeys(String.valueOf(p_text));
        } catch (Exception p_ex) {
            throw new TestException("Cannot setElementText: " + p_ex);
        }
    }

    public void waitForPresence(By locatorOfElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.presenceOfElementLocated(locatorOfElement));
        } catch (Exception p_ex) {
            throw new TestException("Element by locator " + locatorOfElement + " was not found");
        }
    }

    public String getLocatorText(By p_locator) {
        WebElement webElement = wd.driver.findElement(p_locator);
        return webElement.getText();
    }

    public boolean isUrlEnds(String p_string) {
        String currentURL = getCurrentUrl();

        if (currentURL.endsWith(p_string)) {
            return true;
        }
        return false;
    }

    public String getCurrentUrl() {
        String currentUrl = "";

        try {
            currentUrl = driver.getCurrentUrl();
        } catch (Exception p_ex) {
            throw new TestException("Unable to get current url " + p_ex.toString());
        }

        return currentUrl;
    }

    public void wait(int p_timeOut) throws TestException {
        try {
            int delay = 30;
            int i = 0;
            if (p_timeOut > delay) {
                int attempt = p_timeOut / 30;
                while (i != attempt) {
                    Thread.sleep(delay * 1000);
                    i++;
                    p_timeOut -= delay;
                }
                Thread.sleep(p_timeOut * 1000);
            } else {
                Thread.sleep(p_timeOut * 1000);
            }
        } catch (InterruptedException p_ex) {
            throw new TestException("Cannot pause =>" + p_ex);
        }
    }

    public HashSet<String> getWebElementId(List<WebElement> elements) {
        HashSet<String> ids = new HashSet<String>();
        for (WebElement element : elements) {
            ids.add(element.getAttribute("id"));
        }
        return ids;
    }

    public void defaultWait() {
        wd.wait(1);
    }

    public void scrollUp() {
        // Scrolls to the TOP of the page
        ((JavascriptExecutor) driver).executeScript("scroll(0,-80);");
        wait(1);
    }
}
