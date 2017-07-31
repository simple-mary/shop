package locators;

import org.openqa.selenium.By;

/**
 * Created by Perets on 26.07.2017.
 */
public class IndexPageLocators
{
    public By btnChngLanguage = By.xpath("//span[@class=\"menu_lang\"]/a");
    public By btnSearch = By.xpath("//a[contains(@href, \"/search/\")]");

    public By btnLanguage(String lang) {
        return By.xpath("//a[@class=\"a_menu\" and contains(text(), \" " + lang + "\")]");
    }

    public By linkSection(String p_href) {
        return By.xpath("//a[@href=\"" + p_href + "\" and @title]");
    }
}
