package locators;

import org.openqa.selenium.By;

/**
 * Created by Perets on 26.07.2017.
 */
public class SearchPageLocators
{
    public By formKeyWord = By.id("ptxt");
    public By maxPrice = By.xpath("//input[contains(@name, \"max\")]");
    public By btnPerid = By.xpath("//select[@name=\"pr\"]");
    public By btnSearch = By.id("sbtn");
    public By minPrice = By.xpath("//input[contains(@name, \"min\")]");
    public By linkBookmarks = By.xpath("//b[@class='menu_main']//a[contains(@href, 'favorites')]");
}
