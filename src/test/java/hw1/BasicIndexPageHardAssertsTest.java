package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasicIndexPageHardAssertsTest {

    @Test
    public void testBasicFunctionality() {

        //Setup Chrome driver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        //4 Assert User name in the left-top side of screen that user is logged in
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] navItems = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int i = 0; i < navItems.length; i++) {
            WebElement navElem = driver.findElement(By.cssSelector(".uui-header  .uui-navigation.nav > li:nth-child("
                    + (i + 1) + ") a"));
            String navText = navElem.getText();
            assertTrue(navElem.isDisplayed());
            assertEquals(navText, navItems[i]);
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitImages = driver.findElements(By.cssSelector(".icons-benefit"));
        assertEquals(benefitImages.size(), 4);
        for (WebElement benefitImage : benefitImages) {
            assertTrue(benefitImage.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedBenefitTexts = {
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        };
        List<WebElement> benefitTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(benefitTexts.size(), 4);
        for (WebElement benefitText : benefitTexts) {
            assertTrue(benefitText.isDisplayed());
            assertEquals(benefitText.getText(), expectedBenefitTexts[benefitTexts.indexOf(benefitText)]);
        }

        //9 Assert a text of the main headers
        //10 Assert that there is the iframe in the center of page
        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        //12 Switch to original window back
        //13 Assert a text of the sub header
        //14 Assert that JDI GITHUB is a link and has a proper URL
        //15 Assert that there is Left Section
        //16 Assert that there is Footer

        //17 Close Browser
        driver.close();
    }

}
