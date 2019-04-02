package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.HeaderService;
import enums.SidebarService;
import enums.User;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.PageData.INDEX_PAGE;
import static org.testng.Assert.assertEquals;

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

    @FindBy(css = ".uui-header  .uui-navigation.nav .dropdown")
    private SelenideElement serviceHeaderDropdown;

    @FindBy(css = ".uui-side-bar  .sidebar-menu li[index='3']")
    private SelenideElement serviceSidebarDropdown;

    @FindBy(css = ".uui-header  .uui-navigation.nav .dropdown .dropdown-menu > li")
    private List<SelenideElement> headerNavServices;

    @FindBy(css = ".uui-side-bar  .sidebar-menu li[index='3'] .sub > li")
    private List<SelenideElement> sidebarNavServices;

    @FindBy(xpath = "//nav//a[contains(text(), 'Different elements')]")
    private SelenideElement differentElementsHeaderNavOption;

    @FindBy(xpath = "//nav//a[contains(text(), 'User Table')]")
    private SelenideElement userTableHeaderNavOption;

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
    @When("I open \"Different Elements\" page through \"Service\" header dropdown")
    public void openDifferentElementsPageThroughHeaderDropdown() {
        if (!isServiceHeaderDropDownOpen()) {
            openServiceHeaderDropdown();
        }
        differentElementsHeaderNavOption.click();
    }

    @Step
    @When("I click on \"Service\" button in Header")
    public void openServiceHeaderDropdown() {
        serviceHeaderDropdown.click();
    }

    @Step
    @When("I click on \"Service\" sidebar dropdown")
    public void openServiceSidebarDropdown() {
        serviceSidebarDropdown.click();
    }

    @Step
    @When("I click on \"User Table\" button in Service dropdown")
    public void selectUserTsbleInHeaderDropdown() {
        userTableHeaderNavOption.click();
    }

    //================================checks===================================

    @Step
    @Then("The browser title is correct")
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
    @Then("Header \"Service\" dropdown contains appropriate services")
    public void checkServiceHeaderDropdown() {
        for (HeaderService service : HeaderService.values()) {
            headerNavServices.get(service.position).shouldBe(visible);
            headerNavServices.get(service.position).shouldHave(text(service.headerName));
        }
    }

    @Step
    @Then("Sidebar \"Service\" dropdown contains appropriate services")
    public void checkServiceSidebarDropdown() {
        for (SidebarService service : SidebarService.values()) {
            sidebarNavServices.get(service.position).shouldBe(visible);
            sidebarNavServices.get(service.position).shouldHave(text(service.sidebarName));
        }
    }

    //================================private==================================

    private boolean isServiceHeaderDropDownOpen() {
        return serviceHeaderDropdown.getAttribute("class").contains("open");
    }
}