package assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );
    }

    @Test
    public void verifyImplicitWait() {

        driver.findElement(
                By.xpath("//button[text()='Start']")
        ).click();

        String text = driver.findElement(
                By.id("finish")
        ).getText();

        System.out.println("Text: " + text);

        Assert.assertEquals(
                text,
                "Hello World!",
                "Expected text was not displayed"
        );
    }

    @Test
public void verifyExplicitWait() {

    driver.findElement(
            By.xpath("//button[text()='Start']")
    ).click();

    WebDriverWait wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(10)
    );

    String text = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.id("finish")
            )
    ).getText();

    System.out.println("Text: " + text);

    Assert.assertEquals(
            text,
            "Hello World!",
            "Expected text was not displayed"
    );
}
@Test
public void verifyFluentWait() {

    driver.findElement(
            By.xpath("//button[text()='Start']")
    ).click();

    Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);

    String text = wait.until(driver -> {

        String value = driver.findElement(
                By.id("finish")
        ).getText();

        if (value.isEmpty()) {
            return null;
        }

        return value;
    });

    System.out.println("Text: " + text);

    Assert.assertEquals(
            text,
            "Hello World!",
            "Expected text was not displayed"
    );
}

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}