package hw4;

import base.SelenideTestBase;
import enums.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.User.PITER_CHALOVSKII;

public class DifferentElementsPageSelenideTest extends SelenideTestBase {

    private IndexPageSelenide indexPageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;

    @BeforeClass
    public void beforeClass() {
        indexPageSelenide = page(IndexPageSelenide.class);
        differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);
    }

    @Test
    public void testDifferentElementsPage(){
        User user = PITER_CHALOVSKII;

        //1 Open test site by URL
        indexPageSelenide.openPage();

        //2 Assert Browser title
        indexPageSelenide.checkTitle();

        //3 Perform login
        indexPageSelenide.login(user);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPageSelenide.checkUserName(user);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPageSelenide.openServiceHeaderDropdown();
        indexPageSelenide.checkServiceHeaderDropdown();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPageSelenide.openServiceSidebarDropdown();
        indexPageSelenide.checkServiceSidebarDropdown();

        //7 Open through the header menu Service -> Different Elements Page
        indexPageSelenide.openDifferentElementsPageThroughHeaderDropdown();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPageSelenide.checkElementsPresence();

        //9 Assert that there is Right Section
        differentElementsPageSelenide.checkLogSidebar();

        //10 Assert that there is Left Section
        differentElementsPageSelenide.checkNavSidebar();

        //11 Select checkboxes
        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        //13 Select radio
        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        //15 Select in dropdown
        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        //17 Unselect and assert checkboxes
        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 

    }
}
