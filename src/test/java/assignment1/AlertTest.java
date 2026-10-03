package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void verifyAlertAccept() {

        driver.findElement(
                By.xpath("//button[text()='Click for JS Alert']")
        ).click();

        Alert alert = driver.switchTo().alert();

        String message = alert.getText();

        System.out.println("Alert Message: " + message);

        Assert.assertEquals(
                message,
                "I am a JS Alert",
                "Alert message is incorrect"
        );

        alert.accept();

        System.out.println("Alert accepted successfully");
    }

    @Test
    public void verifyAlertDismiss() {

        driver.findElement(
                By.xpath("//button[text()='Click for JS Confirm']")
        ).click();

        Alert alert = driver.switchTo().alert();

        String message = alert.getText();

        System.out.println("Confirm Message: " + message);

        Assert.assertEquals(
                message,
                "I am a JS Confirm",
                "Confirm alert message is incorrect"
        );

        alert.dismiss();

        System.out.println("Alert dismissed successfully");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}