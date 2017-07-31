package page_object;

import locators.FavoritesPageLocators;

import static helpers.Webdriver.wd;

/**
 * Created by Perets on 27.07.2017.
 */
public class FavoritesPage
{
    public static FavoritesPage favoritesPage = new FavoritesPage();

    private FavoritesPageLocators elements() {
        return new FavoritesPageLocators();
    }

    public void waitForLoad() {
        wd.waitForPresence(elements().blockFavorites);
    }
}
