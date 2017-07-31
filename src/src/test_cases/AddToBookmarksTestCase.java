package test_cases;

import base.TestSuiteBase;
import models.Language;
import models.Sections;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static providers.AddBookmarksDataProvider.addBookmarksDataProvider;
import static test_objects.AddBookMarksAfterSearchTest.addBookMarksAfterSearchTest;

/**
 * Created by Perets on 26.07.2017.
 */
public class AddToBookmarksTestCase extends TestSuiteBase
{
    @DataProvider
    private Object[][] getData() {
        return addBookmarksDataProvider.addAdsToBookmarks();
    }

    @Test(description = "Launches the site", dataProvider = "getData", enabled = true)
    public void addToBookmarks(String p_url, Language p_language, Sections p_sections, String p_searchKey,
                               int p_maxPrice, int p_minPrice, String p_period, int p_ads) {
        System.out.println("You are testing on browser ");
        System.out.println(System.getProperty("user.dir"));
        addBookMarksAfterSearchTest.addBookMarksAfterSearchTest(p_url, p_language, p_sections, p_searchKey, p_maxPrice,
                p_minPrice, p_period, p_ads);
    }

}
