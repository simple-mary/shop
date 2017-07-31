package locators;

import org.openqa.selenium.By;

/**
 * Created by Perets on 26.07.2017.
 */
public class SearchResultPageLocators
{
    public By formFoundAds = By.id("filter_frm");
    public By btnSortByPrice = By.xpath("//tr//td[@class=\"msg_column_td\"]");
    public By linkItemSell = By.xpath("//option[contains(@value, 'search-result/sell')]");
    public By linkExpandSearch = By.xpath("//td/a[contains(@href, 'search')]");
    public By selectBargainType = By.xpath("//select[@class='filter_sel']");
    public By checkboxAds = By.xpath("//td/input[@type=\"checkbox\"]");
    public By linkAddToBookmarks = By.xpath("//a[@id='a_fav_sel']");
    public By blockSuccessBannerAddBookmarks = By.xpath("//div[@id='alert_msg']");
    public By btnOkSuccessBannerAddBookmarks = By.xpath("//a[@id='alert_ok']");
}
