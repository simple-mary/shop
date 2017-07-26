package models;

/**
 * Created by Perets on 26.07.2017.
 */
public class TestModel
{
    private String os;
    private Browsers browserName;
    private String siteName;


    public static final TestModel testModel = new TestModel();

    public String getOs() {
        return os;
    }

    public TestModel setOs(String os) {
        this.os = os;
        return this;
    }

    public Browsers getBrowserName() {
        return browserName;
    }

    public TestModel setBrowserName(Browsers browserName) {
        this.browserName = browserName;
        return this;
    }

    public String getSiteName() {
        return os;
    }

    public TestModel setSiteName(String siteName) {
        this.siteName = siteName;
        return this;
    }
}
