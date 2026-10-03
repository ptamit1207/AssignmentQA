package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() throws InterruptedException  {

        loginPage.login("standard_user", "secret_sauce");

           Thread.sleep(3000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );
    }

    @Test
    public void invalidLoginTest() throws InterruptedException {

        loginPage.login("wrong_user", "wrong_pass");

        String error = loginPage.getErrorMessage();

           Thread.sleep(3000);

        Assert.assertTrue(
                error.contains("Epic sadface: Username and password do not match any user in this service")
            
        );
        System.out.println(error);
        
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}