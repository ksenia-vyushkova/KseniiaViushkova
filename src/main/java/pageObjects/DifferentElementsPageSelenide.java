package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class DifferentElementsPageSelenide {

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement navSidebar;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement logSidebar;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "[type='radio']")
    private ElementsCollection radioButtons;

    @FindBy(css = "select")
    private SelenideElement select;

    @FindBy(css = ".uui-button:not(.btn-login)")
    private ElementsCollection buttons;

    //================================methods==================================


    //================================checks===================================

    public void checkNavSidebar() {
        navSidebar.shouldBe(visible);
    }

    public void checkLogSidebar() {
        logSidebar.shouldBe(visible);
    }

    public void checkElementsPresence(){
        checkboxes.shouldHaveSize(4);
        radioButtons.shouldHaveSize(4);
        select.shouldBe(visible);
        buttons.shouldHaveSize(2);
    }
}
