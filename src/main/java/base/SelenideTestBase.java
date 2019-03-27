package base;

import com.codeborne.selenide.Configuration;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(AllureAttachmentListener.class)
public class SelenideTestBase {

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 100;
        Configuration.collectionsPollingInterval = 200;
    }
}