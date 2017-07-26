package locators;

import org.openqa.selenium.By;

/**
 * Created by Perets on 26.07.2017.
 */
public class IndexPageLocators
{
    public By btnChngLanguage = By.xpath("//span[@class=\"menu_lang\"]/a");
    public By btnSearch = By.xpath("//a[contains(@href, \"/search/\")]");

    public By getSection(String id)
    {
        return By.id(id);
    }
}
