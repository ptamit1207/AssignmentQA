package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void verifyMultipleWindows() {

        String parentWindow = driver.getWindowHandle();

        driver.findElement(
                By.linkText("Click Here")
        ).click();

        Set<String> windows = driver.getWindowHandles();

        System.out.println("Total Windows: " + windows.size());

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                break;
            }
        }

        String heading = driver.findElement(
                By.tagName("h3")
        ).getText();

        System.out.println("New Window Heading: " + heading);

        Assert.assertEquals(
                heading,
                "New Window",
                "New window was not opened correctly"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}