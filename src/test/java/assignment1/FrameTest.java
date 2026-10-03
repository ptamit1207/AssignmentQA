package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    public void verifyNestedFrames() {

        // Switch to the top-level frame
        driver.switchTo().frame("frame-top");

        // Switch to the middle frame inside frame-top
        driver.switchTo().frame("frame-middle");

        String text = driver.findElement(
                By.tagName("body")
        ).getText();

        System.out.println("Frame Text: " + text);

        Assert.assertEquals(
                text,
                "MIDDLE",
                "Middle frame text is incorrect"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}