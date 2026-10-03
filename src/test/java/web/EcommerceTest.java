package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }

   

@Test
public void verifyProductsPage() {

    driver.findElement(By.xpath("//a[@href='/products']")).click();

    

    String currentUrl = driver.getCurrentUrl();

    System.out.println("Current URL: " + currentUrl);

    Assert.assertTrue(
            currentUrl.contains("products"),
            "Products page was not opened. Actual URL: " + currentUrl
    );
}
@Test
public void searchProduct() throws InterruptedException {

    driver.get("https://automationexercise.com/products");

    Thread.sleep(2000);

    driver.findElement(
            By.xpath("//input[@id='search_product']")
    ).sendKeys("Top");

    driver.findElement(
            By.xpath("//button[@id='submit_search']")
    ).click();

    Thread.sleep(2000);

    String heading = driver.findElement(
            By.xpath("//h2[contains(text(),'SEARCHED PRODUCTS')]")
    ).getText();

    System.out.println("Search Heading: " + heading);

    Assert.assertEquals(
            heading,
            "SEARCHED PRODUCTS",
            "Searched Products heading is not displayed"
    );
}
@Test
public void verifyThreeProductsDisplayed() throws InterruptedException {

    driver.get("https://automationexercise.com/products");

    Thread.sleep(2000);

    driver.findElement(
            By.xpath("//input[@id='search_product']")
    ).sendKeys("Top");

    driver.findElement(
            By.xpath("//button[@id='submit_search']")
    ).click();

    Thread.sleep(2000);

    int productCount = driver.findElements(
            By.xpath("//div[@class='product-image-wrapper']")
    ).size();

    System.out.println("Products Found: " + productCount);

    Assert.assertTrue(
            productCount >= 3,
            "Less than 3 products were displayed"
    );
}

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}