package hw2.ex1;

import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasicIndexPageDataProviderTest {

    @Test(dataProvider = "benefitTextDataProvider", dataProviderClass = DataProviders.class)
    public void testBenefitTextsWithDataProvider(String expectedBenefitText, int textPosition) {
        //Setup Chrome driver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI");

        //2 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        WebElement benefitText = benefitTexts.get(textPosition);
        assertTrue(benefitText.isDisplayed());
        assertEquals(benefitText.getText(), expectedBenefitText);

        //3 Close Browser
        driver.close();
    }

}
