package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.NavService;
import enums.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.IndexPageElements.INDEX_PAGE_ELEMENTS;
import static enums.PageData.INDEX_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPageSelenideCucumber {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement profileButton;

    @FindBy(css = "#name")
    private SelenideElement login;

    @FindBy(css = "#password")
    private SelenideElement password;

    @FindBy(css = "#login-button")
    private SelenideElement loginButton;

    @FindBy(css = "#user-name")
    private SelenideElement userName;

    @FindBy(css = ".icons-benefit")
    private ElementsCollection benefitImages;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitTexts;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".uui-header  .uui-navigation.nav .dropdown")
    private SelenideElement serviceHeaderDropdown;

    @FindBy(css = ".uui-side-bar  .sidebar-menu li[index='3']")
    private SelenideElement serviceSidebarDropdown;

    @FindBy(css = ".uui-header  .uui-navigation.nav .dropdown .dropdown-menu > li")
    private ElementsCollection headerNavServices;

    @FindBy(css = ".uui-side-bar  .sidebar-menu li[index='3'] .sub > li")
    private ElementsCollection sidebarNavServices;

    public IndexPageSelenideCucumber() {
        page(this);
    }

    //================================methods==================================

    @Step
    @When("I'm on the Home Page")
    public void openPage() {
        open(INDEX_PAGE.url);
    }

    @Step
    @When("I login as user (.+)")
    public void login(User user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        loginButton.click();
    }

    @Step
    @When("I open (.+) page through Service header dropdown")
    public void openDifferentElementsPageThroughHeaderDropdown(NavService service) {
        if (!isServiceHeaderDropDownOpen()) {
            openServiceHeaderDropdown();
        }
        headerNavServices.find(text(service.headerName)).click();
    }

    @Step
    @When("I open Service dropdown in header")
    public void openServiceHeaderDropdown() {
        serviceHeaderDropdown.click();
    }

    @Step
    @When("I open Service sidebar dropdown")
    public void openServiceSidebarDropdown() {
        serviceSidebarDropdown.click();
    }

    //================================checks===================================

    @Step
    @Then("The page title is correct")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), INDEX_PAGE.title);
    }

    @Step
    @Then("Username is displayed and has value pertaining to user (.+)")
    public void checkUserName(User user) {
        userName.shouldBe(visible);
        userName.shouldHave(text(user.userName));
    }

    @Step
    @Then("Home Page contains main elements")
    public void checkMainElements() {
        checkBenefitImages(INDEX_PAGE_ELEMENTS.nImages);
        checkBenefitTexts(INDEX_PAGE_ELEMENTS.benefitTexts);
        checkMainTitle(INDEX_PAGE_ELEMENTS.mainTitle);
        checkMainText(INDEX_PAGE_ELEMENTS.mainText);
    }

    @Step
    @Then("Header Service dropdown contains services:")
    public void checkServiceHeaderDropdown(List<NavService> services) {
        List<String> expectedServiceNames = services.stream().map(i -> i.headerName).collect(Collectors.toList());
        List<String> actualServiceNames = headerNavServices.stream().map(WebElement::getText).collect(Collectors.toList());

        headerNavServices.forEach(i -> i.shouldBe(visible));
        assertEquals(actualServiceNames, expectedServiceNames);

    }

    @Step
    @Then("Sidebar Service dropdown contains services:")
    public void checkServiceSidebarDropdown(List<NavService> services) {
        List<String> expectedServiceNames = services.stream().map(i -> i.sidebarName).collect(Collectors.toList());
        List<String> actualServiceNames = sidebarNavServices.stream().map(WebElement::getText).collect(Collectors.toList());

        sidebarNavServices.forEach(i -> i.shouldBe(visible));
        assertEquals(actualServiceNames, expectedServiceNames);
    }

    //================================private==================================

    private boolean isServiceHeaderDropDownOpen() {
        return serviceHeaderDropdown.getAttribute("class").contains("open");
    }

    private void checkBenefitImages(int expectedImagesCount) {
        assertEquals(benefitImages.size(), expectedImagesCount);
        for (WebElement benefitImage : benefitImages) {
            assertTrue(benefitImage.isDisplayed());
        }
    }

    private void checkBenefitTexts(List<String> expectedBenefitTexts) {
        assertEquals(benefitTexts.size(), expectedBenefitTexts.size());
        benefitTexts.forEach(item -> assertTrue(item.isDisplayed()));
        List<String> actualBenefitTexts = benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(actualBenefitTexts, expectedBenefitTexts);
    }

    private void checkMainTitle(String expectedMainTitle) {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), expectedMainTitle);
    }

    private void checkMainText(String expectedMainText) {
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), expectedMainText);
    }
}