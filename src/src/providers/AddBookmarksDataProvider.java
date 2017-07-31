package providers;

import models.Language;
import models.Sections;

import static models.TestModel.testModel;

/**
 * Created by Perets on 26.07.2017.
 */
public class AddBookmarksDataProvider
{
    public static AddBookmarksDataProvider addBookmarksDataProvider = new AddBookmarksDataProvider();

    public Object[][] addAdsToBookmarks() {
        return new Object[][]
                {
                        {testModel.getSiteName(), Language.RU, Sections.ELECTRONICS, "Компьютер", 300, 0, "7", 3}
                };
    }
}
