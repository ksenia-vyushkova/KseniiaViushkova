package hw4;

import base.SelenideTestBase;
import enums.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.PageData.INDEX_PAGE;
import static enums.User.PITER_CHALOVSKII;

@Feature("Smoke Test")
@Story("Dates Page Sliders Test")
@Listeners(AllureAttachmentListener.class)
public class DatesPageSlidersSelenideTest extends SelenideTestBase {

    private IndexPageSelenide indexPageSelenide;
    private DatesPageSelenide datesPageSelenide;
    private User user = PITER_CHALOVSKII;

    @BeforeClass
    public void beforeClass() {
        indexPageSelenide = open(INDEX_PAGE.url,IndexPageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @AfterMethod
    public void afterMethod() {
        getWebDriver().manage().deleteAllCookies();
    }

    @Flaky
    @Test
    public void testDatesPage() {
        //1 Open test site by URL
        indexPageSelenide.openPage();

        //2 Assert Browser title
        indexPageSelenide.checkTitle();

        //3 Perform login
        indexPageSelenide.login(user);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPageSelenide.checkUserName(user);

        //5 Open through the header menu Service -> Dates Page
        indexPageSelenide.openDatesPageThroughSidebarDropdown();

        //6, 7 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.setSlider(0, 100);
        datesPageSelenide.checkLog(0, 100);

        //8, 9 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.setSlider(0, 0);
        datesPageSelenide.checkLog(0, 0);

        //10, 11 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.setSlider(100, 100);
        datesPageSelenide.checkLog(100, 100);

        //12, 13 Using drag-and-drop set Range sliders.
        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.setSlider(30, 70);
        datesPageSelenide.checkLog(30, 70);
    }
}