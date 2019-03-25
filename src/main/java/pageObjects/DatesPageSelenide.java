package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.elements.Log.SLIDER_LOG;
import static enums.elements.Slider.LEFT_SLIDER;
import static enums.elements.Slider.RIGHT_SLIDER;
import static java.lang.Math.*;
import static org.testng.Assert.assertEquals;

// TODO
/*
In general, this PO is ok, but from my perspective it will be better with methods:
1. setSlider(int, int) - for set up both slider's values
2. checkLog(int, int)
This allow you to decrease amount of code and increase readability of your tests.
 */
public class DatesPageSelenide {

    @FindBy(css = ".ui-slider-horizontal > .ui-slider-handle:first-child")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-horizontal > .ui-slider-handle:not(:first-child)")
    private SelenideElement rightSlider;

    @FindBy(css = ".ui-slider-horizontal")
    private SelenideElement sliderBar;

    @FindBy(css = ".logs > li:nth-child(-n+2)")
    private List<SelenideElement> logs;

    //================================methods==================================

    public void setSlider(int position1, int position2) {
        int leftPosition = min(position1, position2);
        int rightPosition = max(position1, position2);
        int curRightPosition = Integer.parseInt(rightSlider.text());
        if (curRightPosition < leftPosition) {
            dragAndDropToPosition(rightSlider, rightPosition);
            dragAndDropToPosition(leftSlider, leftPosition);
        } else {
            dragAndDropToPosition(leftSlider, leftPosition);
            dragAndDropToPosition(rightSlider, rightPosition);
        }
    }

    //================================checks===================================

    public void checkLog(int position1, int position2) {
        int leftPosition = min(position1, position2);
        int rightPosition = max(position1, position2);

        List<String> expectedLogs = new LinkedList<>();
        expectedLogs.add(SLIDER_LOG.constructLog(LEFT_SLIDER.alias, String.valueOf(leftPosition)));
        expectedLogs.add(SLIDER_LOG.constructLog(RIGHT_SLIDER.alias, String.valueOf(rightPosition)));
        expectedLogs.sort(String::compareTo);

        List<String> actualLogs = logs.stream()
                .map(SelenideElement::text)
                .map(item -> item.substring(SLIDER_LOG.nIgnoresSymbols))
                .sorted()
                .collect(Collectors.toList());

        assertEquals(actualLogs, expectedLogs);
    }

    //================================private==================================

    private void dragAndDropToPosition(SelenideElement slider, int position) {
        double sliderLeftPosition = getCssValueAsDouble(slider, "left");
        double sliderBarWidth = getCssValueAsDouble(sliderBar, "width");
        int xOffset = (int) floor(sliderBarWidth / 100 * position - sliderLeftPosition);
        Actions actions = new Actions(getWebDriver());
        actions.dragAndDropBy(slider, xOffset, 0).build().perform();
    }

    private double getCssValueAsDouble(SelenideElement element, String cssProperty) {
        return Double.parseDouble(element.getCssValue(cssProperty).replace("px", ""));
    }
}