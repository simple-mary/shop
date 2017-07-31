package page_object;

import locators.SearchPageLocators;

import static helpers.Webdriver.wd;

/**
 * Created by Perets on 27.07.2017.
 */
public class SearchPage
{
    public static SearchPage searchPage = new SearchPage();
    private String searchKey;

    private SearchPageLocators elements() {
        return new SearchPageLocators();
    }

    public void waitForLoad() {
        wd.waitForPresence(elements().btnSearch);
    }

    public void typeSearchWord(String searchKey) {
        wd.setElementText(elements().formKeyWord, searchKey);
        wd.click(elements().formKeyWord);
        wd.wait(1);
    }

    public void setMaxPrice(int p_maxPrice) {
        wd.setElementText(elements().maxPrice, Integer.toString(p_maxPrice));
    }

    public void selectSearchPeriod(String p_period) {
        wd.selectItemInList(elements().btnPerid, p_period);
        wd.defaultWait();
    }


    public void clickBtnSearch() {
        wd.click(elements().btnSearch);
        wd.defaultWait();
    }

    public void setMinPrice(int p_minPrice) {
        wd.setElementText(elements().minPrice, Integer.toString(p_minPrice));
        wd.defaultWait();
    }

    public void openBookmarks() {
        wd.scrollUp();
        wd.click(elements().linkBookmarks);
    }
}
