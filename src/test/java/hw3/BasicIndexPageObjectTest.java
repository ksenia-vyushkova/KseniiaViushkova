package hw3;

import base.BasicTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.IndexPage;

import java.util.concurrent.TimeUnit;

public class BasicIndexPageObjectTest extends BasicTestBase {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        indexPage.open();
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testBasicFunctionality() {
        //1, 2 Assert Browser title
        indexPage.checkTitle();

        //3 Perform login
        indexPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is logged in
        indexPage.checkUserName("PITER CHAILOVSKII");

        //5 Assert Browser title
        indexPage.checkTitle();

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] expectedNavItems = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        indexPage.checkNavItems(expectedNavItems);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        indexPage.checkBenefitImages(4);

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedBenefitTexts = {
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        };
        indexPage.checkBenefitTexts(expectedBenefitTexts);

        //9 Assert a text of the main headers
        String expectedMainTitle = "EPAM FRAMEWORK WISHES…";
        String expectedMainText = "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
                "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        indexPage.checkMainTitle(expectedMainTitle);
        indexPage.checkMainText(expectedMainText);

        //10 Assert that there is the iframe in the center of page
        indexPage.checkIframe();

        //11, 12 Switch to the iframe and check that there is Epam logo in the left top conner of iframe. Switch to original window back
        indexPage.checkLogoInIframe();

        //13 Assert a text of the sub header
        indexPage.checkSubTitle();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkJdiLink();

        //15 Assert that there is Left Section
        indexPage.checkNavSidebar();

        //16 Assert that there is Footer
        indexPage.checkFooter();
    }
}
