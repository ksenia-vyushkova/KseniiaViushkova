package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.UserTableUser;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTablePageSelenideCucumber {

    @FindBy(css = "#user-table tr td:nth-child(1)")
    private ElementsCollection orderNumbers;

    @FindBy(css = "#user-table select")
    private ElementsCollection roleSelects;

    @FindBy(css = "#user-table tr td:nth-child(3) a")
    private ElementsCollection userNames;

    @FindBy(css = "#user-table img")
    private ElementsCollection descriptionImages;

    @FindBy(css = "#user-table .user-descr span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "#user-table input")
    private ElementsCollection userCheckboxes;

    @FindBy(css = ".logs > li")
    private ElementsCollection logs;

    public UserTablePageSelenideCucumber() {
        page(this);
    }

    //================================methods==================================

    @Step
    @When("I select \"vip\" checkbox for (.+)")
    public void selectVipCheckboxForUser(UserTableUser user) {
        userCheckboxes.filter(Condition.id(user.cssId)).get(0).click();
    }

    @Step
    @When("I click on dropdown in column Type for user (.+)")
    public void selectRoleForUser(UserTableUser user) {
        roleSelects.get(user.position).click();
    }

    //================================checks===================================

    @Step
    @Then("\"User Table\" page is opened")
    public void checkUserTablePageIsOpened() {
        assertTrue(getWebDriver().getCurrentUrl().contains("user-table.html"));
    }

    @Step
    @Then("{int} NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkRoleSelects(int n) {
        roleSelects.shouldHaveSize(n);
        roleSelects.forEach(SelenideElement::isDisplayed);
    }

    @Step
    @Then("{int} User names are displayed on Users Table on User Table Page")
    public void checkUserNames(int n) {
        userNames.shouldHaveSize(n);
        userNames.forEach(SelenideElement::isDisplayed);
    }

    @Step
    @Then("{int} Description images are displayed on Users Table on User Table Page")
    public void checkDescriptionImages(int n) {
        descriptionImages.shouldHaveSize(n);
        descriptionImages.forEach(SelenideElement::isDisplayed);
    }

    @Step
    @Then("{int} Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionTexts(int n) {
        descriptionTexts.shouldHaveSize(n);
        descriptionTexts.forEach(SelenideElement::isDisplayed);
    }

    @Step
    @Then("{int} checkboxes are displayed on Users Table on User Table Page")
    public void checkUserCheckboxes(int n) {
        userCheckboxes.shouldHaveSize(n);
        userCheckboxes.forEach(SelenideElement::isDisplayed);
    }

    @Then("User table contains following values:")
    public void userTableContainsFollowingValues(DataTable dt) {
        List<Map<String, String>> expectedUserTableEntries = dt.asMaps(String.class, String.class);
        expectedUserTableEntries.forEach(this::checkUserTableRow);
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int n, String logText) {
        logs.shouldHaveSize(n);
        logs.get(0).shouldHave(text(logText));
    }

    @Then("droplist contains expected values for user (.+)")
    public void droplistContainsValues(UserTableUser user, DataTable dt) {
        List<String> expectedRoleSelectOptions = dt.column(0);
        List<String> actualRoleSelectOptions = roleSelects.get(user.position).findAll("option").texts();
        assertEquals(actualRoleSelectOptions, expectedRoleSelectOptions);
    }

    //================================private==================================

    private void checkUserTableRow(Map<String, String> entry) {
        assertEquals(orderNumbers.get(parseInt(entry.get("Number")) - 1).text(), entry.get("Number"));
        assertEquals(userNames.get(parseInt(entry.get("Number")) - 1).text(), entry.get("User"));
        assertEquals(descriptionTexts.get(parseInt(entry.get("Number")) - 1).text(), entry.get("Description"));
    }
}