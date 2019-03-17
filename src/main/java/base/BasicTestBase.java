package base;

import org.testng.annotations.BeforeSuite;

public class BasicTestBase {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
}
