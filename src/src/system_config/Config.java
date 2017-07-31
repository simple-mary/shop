package system_config;

import static models.TestModel.testModel;

/**
 * Created by Perets on 26.07.2017.
 */
public class Config
{
    public static int WEBDRIVER_WAIT = 10;

    public static Config config = new Config();

    public Config() {
        String path = System.getProperty("user.dir");
        String firefoxDriverPath = testModel.getOs().equals("windows") ? "/libs/geckodriver/win64/geckodriver.exe" :
                "/libs/geckodriver/linux64/geckodriver";
        String chromeDriverPath = testModel.getOs().equals("windows") ? "/libs/chromedriver/win/chromedriver.exe" :
                "/libs/chromedriver/linux64/chromedriver";
        System.setProperty("webdriver.gecko.driver", path + firefoxDriverPath);
        System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);
    }

}
