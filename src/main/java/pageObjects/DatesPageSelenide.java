package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.elements.Slider;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.elements.Slider.LEFT_SLIDER;

public class DatesPageSelenide {

    @FindBy(css = ".ui-slider-horizontal > a:first-child")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-horizontal > a:not(:first-child)")
    private SelenideElement rightSlider;

    @FindBy(css = ".ui-slider-horizontal")
    private SelenideElement sliderBar;

    @FindBy(css = ".logs > li:first-child")
    private SelenideElement log;

    //================================methods==================================

    public void dragAndDropToPosition(Slider sl, int position) {
        SelenideElement slider = sl.equals(LEFT_SLIDER) ? leftSlider : rightSlider;
        double sliderLeftPosition = getCssValueAsDouble(slider, "left");
        double sliderBarWidth = getCssValueAsDouble(sliderBar, "width");
        int xOffset = (int) Math.floor(sliderBarWidth / 100 * position - sliderLeftPosition);
        Actions actions = new Actions(getWebDriver());
        actions.dragAndDropBy(slider, xOffset, 0).build().perform();
    }

    private double getCssValueAsDouble(SelenideElement element, String cssProperty) {
        return Double.parseDouble(element.getCssValue(cssProperty).replace("px", ""));
    }

    //================================checks===================================

    public void checkLastLogContains(Slider sl, Integer position) {
        log.shouldHave(text(sl.alias));
        log.shouldHave(text(position.toString()));
    }
}