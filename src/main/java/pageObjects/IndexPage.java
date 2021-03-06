package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

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

    @Step
    public void open() {
        driver.navigate().to("https://epam.github.io/JDI");
    }

    @Step
    public void login(String name, String pwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(pwd);
        loginButton.click();
    }

    //================================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserName(String expectedUserName) {
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), expectedUserName);
    }

    @Step
    public void checkNavItems(List<String> expectedNavItems) {
        assertEquals(navItems.size(), expectedNavItems.size());
        navItems.forEach(item -> assertTrue(item.isDisplayed()));

        List<String> actualNavItems = navItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertEquals(actualNavItems, expectedNavItems);
    }

    @Step
    public void checkBenefitImages(int expectedImagesCount) {
        assertEquals(benefitImages.size(), expectedImagesCount);
        for (WebElement benefitImage : benefitImages) {
            assertTrue(benefitImage.isDisplayed());
        }
    }

    @Step
    public void checkBenefitTexts(List<String> expectedBenefitTexts) {
        assertEquals(benefitTexts.size(), expectedBenefitTexts.size());
        benefitTexts.forEach(item -> assertTrue(item.isDisplayed()));
        List<String> actualBenefitTexts = benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(actualBenefitTexts, expectedBenefitTexts);
    }

    @Step
    public void checkMainTitle(String expectedMainTitle) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), expectedMainTitle);
    }

    @Step
    public void checkMainText(String expectedMainText) {
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), expectedMainText);
    }

    @Step
    public void checkIframe() {
        assertTrue(iframes.size() > 0);
    }

    @Step
    public void checkLogoInIframe() {
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement(By.cssSelector("#epam_logo")).isDisplayed());
        driver.switchTo().defaultContent();
    }

    @Step
    public void checkSubTitle(String expectedSubTitle) {
        assertTrue(subTitle.isDisplayed());
        assertEquals(subTitle.getText(), expectedSubTitle);
    }

    @Step
    public void checkJdiLink(String expectedJdiLinkHref) {
        assertTrue(jdiLink.isDisplayed());
        assertEquals(jdiLink.getAttribute("href"), expectedJdiLinkHref);
    }

    @Step
    public void checkNavSidebar() {
        assertTrue(navSidebar.isDisplayed());
    }

    @Step
    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}
