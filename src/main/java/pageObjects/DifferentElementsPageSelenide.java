package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.elements.CheckBox;
import enums.elements.RadioButton;
import enums.elements.SelectOption;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPageSelenide {

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

    //================================methods==================================

    @Step
    public void tickCheckBox(CheckBox cb) {
        SelenideElement checkBox = checkBoxes.get(cb.position);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    @Step
    public void untickCheckBox(CheckBox cb) {
        SelenideElement checkBox = checkBoxes.get(cb.position);
        if (checkBox.isSelected()) {
            checkBox.click();
        }
    }

    @Step
    public void tickRadioButton(RadioButton rb) {
        radioButtons.get(rb.position).click();
    }

    @Step
    public void selectColor(SelectOption so) {
        select.selectOption(so.option);
    }

    //================================checks===================================

    @Step
    public void checkNavSidebar() {
        navSidebar.shouldBe(visible);
    }

    @Step
    public void checkLogSidebar() {
        logSidebar.shouldBe(visible);
    }

    @Step
    public void checkElementsPresence() {
        checkBoxes.shouldHaveSize(CheckBox.values().length);
        radioButtons.shouldHaveSize(RadioButton.values().length);
        select.shouldBe(visible);
        buttons.shouldHaveSize(2);
    }

    @Step
    public void checkLastLogContains(String elementName, String elementValue) {
        log.shouldHave(text(elementName));
        log.shouldHave(text(elementValue));
    }

    @Step
    public void checkCheckBoxUnchecked(CheckBox cb) {
        checkBoxes.get(cb.position).shouldNotBe(selected);
    }
}