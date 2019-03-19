package hw4;

import base.SelenideTestBase;
import enums.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.User.PITER_CHALOVSKII;

public class DatesPageSlidersSelenideTest extends SelenideTestBase {

    private IndexPageSelenide indexPageSelenide;
    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        indexPageSelenide = page(IndexPageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void testDatesPage() {
        User user = PITER_CHALOVSKII;

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

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        //12 Using drag-and-drop set Range sliders.
        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
    }
}
