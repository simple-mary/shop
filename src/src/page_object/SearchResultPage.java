package page_object;


import locators.SearchResultPageLocators;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static helpers.Webdriver.wd;

/**
 * Created by Perets on 27.07.2017.
 */
public class SearchResultPage
{
    public static SearchResultPage searchResultPage = new SearchResultPage();

    private SearchResultPageLocators elements() {
        return new SearchResultPageLocators();
    }

    public void waitForLoad() {
        wd.waitForPresence(elements().formFoundAds);
    }

    public void clickSortByPrice() {
        wd.click(elements().btnSortByPrice);
    }

    public void selectBargainTypeSell() {
        wd.selectItemInList(elements().selectBargainType, 1);
    }

    public void clickExpandSearch() {
        wd.click(elements().linkExpandSearch);
    }

    public List<WebElement> selectAds(int p_ads) {
        List<WebElement> elements = wd.driver.findElements(elements().checkboxAds);
        List<WebElement> selectedEl = new ArrayList<WebElement>();
        int size = elements.size();
        for (int i = 0; i < p_ads; i++) {
            int ind = getRandomElement(size);
            WebElement elementAdded = elements.get(ind);
            selectedEl.add(elementAdded);
        }
        return selectedEl;
    }

    public List<WebElement> getAds() {
        List<WebElement> elements = wd.driver.findElements(elements().checkboxAds);
        return elements;
    }

    public void clickCheckbox(List<WebElement> elements) {
        for (WebElement element : elements) {
            element.click();
            wd.defaultWait();
        }
    }

    private int getRandomElement(int size) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(size);
    }

    public void addSelectedToBookmarks() {
        wd.click(elements().linkAddToBookmarks);
        wd.defaultWait();
    }

    public void waitForSuccessBannerAddBookmarks() {
        wd.waitForPresence(elements().blockSuccessBannerAddBookmarks);
    }

    public void clickOKSuccessBannerAddBookmarks() {
        wd.click(elements().btnOkSuccessBannerAddBookmarks);
    }
}
