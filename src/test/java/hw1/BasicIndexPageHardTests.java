package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BasicIndexPageHardTests {

    @Test
    public void testBasicFunctionality() {

        // Setup Chrome driver
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Step 1. Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI");

        // Step 2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // Step 3. Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        // Step 4. Assert User name in the left-top side of screen that user is logged in
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");

        // Step 5. Assert Browser title
        // Step 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        // Step 7. Assert that there are 4 images on the Index Page and they are displayed
        // Step 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // Step 9. Assert a text of the main headers
        // Step 10. Assert that there is the iframe in the center of page
        // Step 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        // Step 12. Switch to original window back
        // Step 13. Assert a text of the sub header
        // Step 14. Assert that JDI GITHUB is a link and has a proper URL
        // Step 15. Assert that there is Left Section
        // Step 16. Assert that there is Footer
        // Step 17. Close Browser
        // Step 1. Open test site by URL
        // Step 2. Assert Browser title
        // Step 3. Perform login
        // Step 4. Assert User name in the left-top side of screen that user is loggined
        // Step 5. Assert Browser title
        // Step 6. Assert that there are 4 items on the header section are displayed and they have proper texts
        // Step 7. Assert that there are 4 images on the Index Page and they are displayed
        // Step 8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // Step 9. Assert a text of the main headers
        // Step 10. Assert that there is the iframe in the center of page
        // Step 11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        // Step 12. Switch to original window back
        // Step 13. Assert a text of the sub header
        // Step 14. Assert that JDI GITHUB is a link and has a proper URL
        // Step 15. Assert that there is Left Section
        // Step 16. Assert that there is Footer

        // Step 17. Close Browser
        driver.close();
    }

}
