package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    private WebDriver driver;

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement profileButton;

    @FindBy(css = "#name")
    private WebElement login;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    @FindBy(css = "#user-name")
    private WebElement userName;

    @FindBy(css = ".uui-header  .uui-navigation.nav > li > a")
    private List<WebElement> navItems;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> benefitImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "h3:not(.main-title)")
    private WebElement subTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = "iframe")
    private List<WebElement> iframes;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement jdiLink;

    @FindBy(css = "[name='navigation-sidebar']")
    private WebElement navSidebar;

    @FindBy(css = "footer")
    private WebElement footer;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //================================methods==================================

    public void open() {
        driver.navigate().to("https://epam.github.io/JDI");
    }

    public void login(String name, String pwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(pwd);
        loginButton.click();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserName(String expectedUserName) {
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), expectedUserName);
    }

    public void checkNavItems(String[] expectedNavItems) {
        assertEquals(navItems.size(), expectedNavItems.length);
        /* TODO Basically, it is not the best idea to create a cycle by WebElement collection,
        cause this might lead us to an issue in some cases (for the example, WebEl with the same text).
         So, the easies way to make this verification is transform List<WebEl> to List<String> and compare
         expected list with actual, TestNg assertion can do it.
         */

        for (WebElement navItem : navItems) {
            assertTrue(navItem.isDisplayed());
            assertEquals(navItem.getText(), expectedNavItems[navItems.indexOf(navItem)]);
        }
    }

    public void checkBenefitImages(int expectedImagesCount) {
        assertEquals(benefitImages.size(), expectedImagesCount);
        for (WebElement benefitImage : benefitImages) {
            assertTrue(benefitImage.isDisplayed());
        }
    }

    public void checkBenefitTexts(String[] expectedBenefitTexts) {
        assertEquals(benefitTexts.size(), expectedBenefitTexts.length);
        for (WebElement benefitText : benefitTexts) {
            assertTrue(benefitText.isDisplayed());
            assertEquals(benefitText.getText(), expectedBenefitTexts[benefitTexts.indexOf(benefitText)]);
        }
    }

    public void checkMainTitle(String expectedMainTitle) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), expectedMainTitle);
    }

    public void checkMainText(String expectedMainText) {
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), expectedMainText);
    }

    public void checkIframe() {
        assertTrue(iframes.size() > 0);
    }

    public void checkLogoInIframe() {
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("#epam_logo")).isDisplayed());
        driver.switchTo().defaultContent();
    }

    public void checkSubTitle(String expectedSubTitle) {
        assertTrue(subTitle.isDisplayed());
        assertEquals(subTitle.getText(), expectedSubTitle);
    }

    public void checkJdiLink(String expectedJdiLinkHref) {
        assertTrue(jdiLink.isDisplayed());
        assertEquals(jdiLink.getAttribute("href"), expectedJdiLinkHref);
    }

    public void checkNavSidebar() {
        assertTrue(navSidebar.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}
