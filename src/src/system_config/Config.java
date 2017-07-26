package system_config;

/**
 * Created by Perets on 26.07.2017.
 */
public class Config
{
    public Config()
    {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/libs/geckodriver/win64/geckodriver.exe");
    }

}
