package cases;

import base.TestSuiteBase;
import org.testng.annotations.Test;

import static helpers.Webdriver.wd;
import static models.TestModel.testModel;

/**
 * Created by Perets on 26.07.2017.
 */
public class AddToBookmarks extends TestSuiteBase
{
    @Test(description="Launches the site")
    public void addToBookmarks()
    {
        System.out.println("You are testing on browser ");
        System.out.println(System.getProperty("user.dir"));
//        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/libs/geckodriver/win64/geckodriver.exe");
        wd.driver.navigate().to(testModel.getSiteName());
    }

}
