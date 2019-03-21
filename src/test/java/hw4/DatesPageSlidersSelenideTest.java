package hw4;

import base.SelenideTestBase;
import enums.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.User.PITER_CHALOVSKII;
import static enums.elements.Slider.LEFT_SLIDER;
import static enums.elements.Slider.RIGHT_SLIDER;

public class DatesPageSlidersSelenideTest extends SelenideTestBase {

    private IndexPageSelenide indexPageSelenide;
    private DatesPageSelenide datesPageSelenide;
    private User user = PITER_CHALOVSKII;

    @BeforeClass
    public void beforeClass() {
        indexPageSelenide = page(IndexPageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @AfterClass
    public void afterClass() {
        getWebDriver().manage().deleteAllCookies();
    }

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
        datesPageSelenide.dragAndDropToPosition(LEFT_SLIDER, 0);
        datesPageSelenide.checkLastLogContains(LEFT_SLIDER, 0);
        datesPageSelenide.dragAndDropToPosition(RIGHT_SLIDER, 100);
        datesPageSelenide.checkLastLogContains(RIGHT_SLIDER, 100);

        //8, 9 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.dragAndDropToPosition(LEFT_SLIDER, 0);
        datesPageSelenide.checkLastLogContains(LEFT_SLIDER, 0);
        datesPageSelenide.dragAndDropToPosition(RIGHT_SLIDER, 0);
        datesPageSelenide.checkLastLogContains(RIGHT_SLIDER, 0);

        //10, 11 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.dragAndDropToPosition(RIGHT_SLIDER, 100);
        datesPageSelenide.checkLastLogContains(RIGHT_SLIDER, 100);
        datesPageSelenide.dragAndDropToPosition(LEFT_SLIDER, 100);
        datesPageSelenide.checkLastLogContains(LEFT_SLIDER, 100);


        //12, 13 Using drag-and-drop set Range sliders.
        //Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.dragAndDropToPosition(LEFT_SLIDER, 30);
        datesPageSelenide.checkLastLogContains(LEFT_SLIDER, 30);
        datesPageSelenide.dragAndDropToPosition(RIGHT_SLIDER, 70);
        datesPageSelenide.checkLastLogContains(RIGHT_SLIDER, 70);
    }
}