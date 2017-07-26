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
    public TestSuiteBase testSuiteBase;

//    public TestSuiteBase()
//    {
//       testSuiteBase = new TestSuiteBase();
//    }

    @BeforeMethod
    @BeforeSuite
    @BeforeTest
    @Parameters({"os", "site", "browserName"})
    public void testBeforeSuiteInit(@Optional String p_os, @Optional String p_site, @Optional Browsers p_browser) {
        Config cnf = new Config();
        // User Build
        testModel.setSiteName(p_site)
        .setBrowserName(p_browser)
        .setOs(p_os);
        wd.runLocalBrowser(testModel.getBrowserName());
    }
}
