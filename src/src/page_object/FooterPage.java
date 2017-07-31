package page_object;

import locators.FooterPageLocators;

import static helpers.Webdriver.wd;

/**
 * Created by Perets on 27.07.2017.
 */
public class FooterPage
{
    public static FooterPage footerPage = new FooterPage();

    private FooterPageLocators elements() {
        return new FooterPageLocators();
    }

    public void waitForLoad() {
        wd.waitForPresence(elements().blockFooter);
    }
}
