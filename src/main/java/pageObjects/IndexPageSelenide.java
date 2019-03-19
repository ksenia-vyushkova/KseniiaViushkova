package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.Service;
import enums.User;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.PageData.INDEX_PAGE;
import static org.testng.Assert.assertEquals;

public class IndexPageSelenide {

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

    @FindBy(css = ".uui-side-bar  .sidebar-menu li[index='3'] .sub")
    private SelenideElement serviceSidebarDropdownMenue;

    @FindBy(css = ".uui-header  .uui-navigation.nav .dropdown .dropdown-menu > li")
    private List<SelenideElement> headerNavServices;

    @FindBy(css = ".uui-side-bar  .sidebar-menu li[index='3'] .sub > li")
    private List<SelenideElement> sidebarNavServices;

    @FindBy(xpath = "//nav//a[contains(text(), 'Different elements')]")
    private SelenideElement differentElementsHeaderNavOption;

    @FindBy(xpath = "//div[@name='navigation-sidebar']//a/span[contains(text(), 'Dates')]")
    private SelenideElement datesSidebarNavOption;

    //================================methods==================================

    public void openPage() {
        open(INDEX_PAGE.url);
    }

    public void openDifferentElementsPageThroughHeaderDropdown() {
        if (!serviceHeaderDropdown.getAttribute("class").contains("open")){
            openServiceHeaderDropdown();
        }
        differentElementsHeaderNavOption.click();
    }

    public void openDatesPageThroughSidebarDropdown() {
        if (serviceSidebarDropdownMenue.getAttribute("class").contains("hide-menu")){
            openServiceSidebarDropdown();
        }
        datesSidebarNavOption.click();
    }

    public void login(User user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        loginButton.click();
    }

    public void openServiceHeaderDropdown(){
        serviceHeaderDropdown.click();
    }

    public void openServiceSidebarDropdown(){
        serviceSidebarDropdown.click();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), INDEX_PAGE.title);
    }

    public void checkUserName(User user) {
        userName.shouldBe(visible);
        userName.shouldHave(text(user.userName));
    }

    public void checkServiceHeaderDropdown(){
        for (Service service : Service.values()){
            headerNavServices.get(service.position).shouldBe(visible);
            headerNavServices.get(service.position).shouldHave(text(service.headerName));
        }
    }

    public void checkServiceSidebarDropdown(){
        for (Service service : Service.values()){
            sidebarNavServices.get(service.position).shouldBe(visible);
            sidebarNavServices.get(service.position).shouldHave(text(service.sidebarName));
        }
    }
}
