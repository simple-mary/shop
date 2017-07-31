package test_objects;

import models.Language;
import models.Sections;
import org.openqa.selenium.WebElement;
import org.testng.TestException;

import java.util.HashSet;
import java.util.List;

import static helpers.Assertion.assertion;
import static helpers.Webdriver.wd;
import static page_object.FooterPage.footerPage;
import static page_object.IndexPage.indexPage;
import static page_object.SearchPage.searchPage;
import static page_object.SearchResultPage.searchResultPage;

/**
 * Created by Perets on 27.07.2017.
 */
public class AddBookMarksAfterSearchTest
{
    public static AddBookMarksAfterSearchTest addBookMarksAfterSearchTest = new AddBookMarksAfterSearchTest();

    public void openUrl(String p_url) {
        wd.driver.navigate().to(p_url);
        footerPage.waitForLoad();
    }

    public void changeLanguage(Language p_lang) {
        indexPage.clickLanguageButton(p_lang);
        footerPage.waitForLoad();
        // verify language has changed
        assertion.assertNotEquals(indexPage.getLanguage(), p_lang.toString(), "Site language");
    }

    public void addBookMarksAfterSearchTest(String p_url, Language p_language, Sections p_sections, String p_searchKey,
                                            int p_maxPrice, int p_minPrice, String p_period, int p_ads) {
        openUrl(p_url);
        changeLanguage(p_language);
        openSection(p_sections);
        clickSearchBtnInTop();
        searchPage.typeSearchWord(p_searchKey);
        // set max price 1000
        searchPage.setMaxPrice(1000);
        //select a week
        searchPage.selectSearchPeriod("7");
        searchPage.clickBtnSearch();
        searchResultPage.waitForLoad();
        searchResultPage.clickSortByPrice();
        searchResultPage.selectBargainTypeSell();
        searchResultPage.clickExpandSearch();
        searchPage.waitForLoad();
        searchPage.setMinPrice(p_minPrice);
        searchPage.setMaxPrice(p_maxPrice);
        searchPage.selectSearchPeriod(p_period);
        searchPage.clickBtnSearch();
        searchResultPage.waitForLoad();
        List<WebElement> selectedAds = searchResultPage.selectAds(p_ads);
        HashSet<String> idsSelectedAds = wd.getWebElementId(selectedAds);
        searchResultPage.clickCheckbox(selectedAds);
        if (selectedAds.size() == 0)
            throw new TestException("No adds were added");
        searchResultPage.addSelectedToBookmarks();
        searchResultPage.waitForSuccessBannerAddBookmarks();
        searchResultPage.clickOKSuccessBannerAddBookmarks();
        searchPage.openBookmarks();
        wd.isUrlEnds("/favotes");
        footerPage.waitForLoad();
        List<WebElement> bookmarkedAds = searchResultPage.getAds();
        HashSet<String> idsBookmarkedAds = wd.getWebElementId(bookmarkedAds);
        if (!idsBookmarkedAds.containsAll(idsSelectedAds))
            throw new TestException("Test failed! Ads were not added to bookmarks");
    }

    public void openSection(Sections p_section) {
        indexPage.clickSection(p_section);
        footerPage.waitForLoad();
        wd.isUrlEnds(p_section.toString().toLowerCase());
    }

    public void clickSearchBtnInTop() {
        indexPage.clickSearchButton();
        wd.isUrlEnds("electronics/search/");
    }
}
