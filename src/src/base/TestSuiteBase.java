package base;

import models.Browsers;
import org.testng.annotations.*;
import system_config.Config;

import static helpers.Webdriver.wd;
import static models.TestModel.testModel;

/**
 * Created by Perets on 26.07.2017.
 */
public class TestSuiteBase
{
    @BeforeSuite
    @Parameters({"os", "site", "browserName"})
    public void initBeforeSuite(@Optional String p_os, @Optional String p_site, @Optional Browsers p_browser) {
        // User Build
        testModel.setSiteName(p_site)
                .setBrowserName(p_browser)
                .setOs(p_os);
        Config cnf = new Config();
    }

    @BeforeTest
    public void initBeforeTest() {
        wd.runLocalBrowser(testModel.getBrowserName());
    }

    @AfterTest
    public void initAfterTest() {
        wd.driver.quit();
    }

}
