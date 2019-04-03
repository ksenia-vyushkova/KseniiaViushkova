package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.elements.CheckBox;
import enums.elements.RadioButton;
import enums.elements.SelectOption;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class DifferentElementsPageSelenideCucumber {

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement navSidebar;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement logSidebar;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkBoxes;

    @FindBy(css = "[type='radio']")
    private ElementsCollection radioButtons;

    @FindBy(css = "select")
    private SelenideElement select;

    @FindBy(css = ".uui-button:not(.btn-login)")
    private ElementsCollection buttons;

    @FindBy(css = ".logs > li:first-child")
    private SelenideElement log;

    public DifferentElementsPageSelenideCucumber() {
        page(this);
    }

    //================================methods==================================

    @Step
    @When("I select (.+) element")
    public void tickCheckBox(CheckBox cb) {
        SelenideElement checkBox = checkBoxes.get(cb.position);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    @Step
    @When("I deselect (.+) element")
    public void untickCheckBox(CheckBox cb) {
        SelenideElement checkBox = checkBoxes.get(cb.position);
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }

    @Step
    @When("I select (.+) material")
    public void tickRadioButton(RadioButton rb) {
        radioButtons.get(rb.position).click();
    }

    @Step
    @When("I select color (.+)")
    public void selectColor(SelectOption so) {
        select.selectOption(so.option);
    }

    //================================checks===================================

    @Step
    @Then("Navigation sidebar is displayed")
    public void checkNavSidebar() {
        navSidebar.shouldBe(visible);
    }

    @Step
    @Then("Log sidebar is displayed")
    public void checkLogSidebar() {
        logSidebar.shouldBe(visible);
    }

    @Step
    @Then("Expected elements are present")
    public void checkElementsPresence() {
        checkBoxes.shouldHaveSize(CheckBox.values().length);
        radioButtons.shouldHaveSize(RadioButton.values().length);
        select.shouldBe(visible);
        buttons.shouldHaveSize(2);
    }

    @Step
    @Then("Last log contains a record about selecting (.+) element")
    public void checkLastLogContains(CheckBox cb) {
        log.shouldHave(text(cb.label));
        log.shouldHave(text(cb.on));
    }

    @Step
    @Then("Last log contains a record about selecting (.+) material")
    public void checkLastLogContains(RadioButton rb) {
        log.shouldHave(text(rb.elementName));
        log.shouldHave(text(rb.label));
    }

    @Step
    @Then("Last log contains a record about selecting color (.+)")
    public void checkLastLogContains(SelectOption so) {
        log.shouldHave(text(so.elementName));
        log.shouldHave(text(so.option));
    }

    @Step
    @Then("Last log contains a record about deselecting (.+) element")
    public void checkLastLogContainsUnselected(CheckBox cb) {
        log.shouldHave(text(cb.label));
        log.shouldHave(text(cb.off));
    }

    @Step
    @Then("Element (.+) is deselected")
    public void checkCheckBoxUnchecked(CheckBox cb) {
        checkBoxes.get(cb.position).shouldNotBe(selected);
    }
}