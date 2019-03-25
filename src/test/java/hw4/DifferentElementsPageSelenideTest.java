package hw4;

import base.SelenideTestBase;
import enums.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.IndexPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.User.PITER_CHALOVSKII;
import static enums.elements.CheckBox.WATER;
import static enums.elements.CheckBox.WIND;
import static enums.elements.RadioButton.SELEN;
import static enums.elements.SelectOption.YELLOW;

public class DifferentElementsPageSelenideTest extends SelenideTestBase {

    private IndexPageSelenide indexPageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;
    private User user = PITER_CHALOVSKII;

    @BeforeClass
    public void beforeClass() {
        indexPageSelenide = page(IndexPageSelenide.class);
        differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);
    }

    @AfterMethod
    public void afterMethod() {
        getWebDriver().manage().deleteAllCookies();
    }

    @Test
    public void testDifferentElementsPage() {
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

        //11, 12 Select checkboxes. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPageSelenide.tickCheckBox(WATER);
        differentElementsPageSelenide.checkLastLogContains(WATER.label, WATER.on);

        differentElementsPageSelenide.tickCheckBox(WIND);
        differentElementsPageSelenide.checkLastLogContains(WIND.label, WIND.on);

        //13, 14 Select radio. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPageSelenide.tickRadioButton(SELEN);
        differentElementsPageSelenide.checkLastLogContains(SELEN.elementName, SELEN.label);

        //15, 16 Select in dropdown. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSelenide.selectColor(YELLOW);
        differentElementsPageSelenide.checkLastLogContains(YELLOW.elementName, YELLOW.option);


        //17, 18 Unselect and assert checkboxes. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPageSelenide.untickCheckBox(WATER);
        differentElementsPageSelenide.checkCheckBoxUnchecked(WATER);
        differentElementsPageSelenide.checkLastLogContains(WATER.label, WATER.off);

        differentElementsPageSelenide.untickCheckBox(WIND);
        differentElementsPageSelenide.checkCheckBoxUnchecked(WIND);
        differentElementsPageSelenide.checkLastLogContains(WIND.label, WIND.off);
    }
}