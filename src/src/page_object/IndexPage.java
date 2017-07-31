package page_object;

import locators.IndexPageLocators;
import models.Language;
import models.Sections;

import static helpers.Webdriver.wd;

/**
 * Created by Perets on 26.07.2017.
 */
public class IndexPage
{
    public static IndexPage indexPage = new IndexPage();

    private IndexPageLocators elements() {
        return new IndexPageLocators();
    }

    public void clickLanguageButton(Language p_language) {
        String lang = getLanguage();
        if (lang.equals(p_language.toString())) {
            wd.click(elements().btnChngLanguage);
        }
    }

    public String getLanguage() {
        return wd.getLocatorText(elements().btnChngLanguage);
    }

    public void clickSection(Sections p_sections) {
        wd.click(elements().linkSection(p_sections.getValue()));
    }

    public void clickSearchButton() {
        wd.click(elements().btnSearch);
    }
}
