package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.PageData.INDEX_PAGE;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 100;
        Configuration.startMaximized = true;
        open(INDEX_PAGE.url);
    }

    @AfterMethod
    public void afterMethod() {
        getWebDriver().manage().deleteAllCookies();
    }
}