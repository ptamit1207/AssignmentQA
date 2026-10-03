package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TableTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://vinothqaacademy.com/webtable/");
    }

    @Test
    public void readTableData() {

        // Find table
        By table = By.xpath("//table");

        // Find all rows
        int rows = driver.findElements(
                By.xpath("//table//tbody/tr")
        ).size();

        // Find all columns
        int columns = driver.findElements(
                By.xpath("//table//thead/tr/th")
        ).size();

        System.out.println("Total Rows: " + rows);
        System.out.println("Total Columns: " + columns);

        // Validate table contains data
        Assert.assertTrue(
                rows > 0,
                "Table does not contain any rows"
        );

        Assert.assertTrue(
                columns > 0,
                "Table does not contain any columns"
        );

        // Print all rows and columns
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= columns; j++) {

                String cellValue = driver.findElement(
                        By.xpath("//table//tbody/tr[" + i + "]/td[" + j + "]")
                ).getText();

                System.out.print(cellValue + " | ");
            }

            System.out.println();
        }
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
public void verifyColumnAndSorting() {

    // Print first column values
    int rows = driver.findElements(
            By.xpath("//table//tbody/tr")
    ).size();

    System.out.println("Column Values:");

    for (int i = 1; i <= rows; i++) {

        String value = driver.findElement(
                By.xpath("//table//tbody/tr[" + i + "]/td[1]")
        ).getText();

        System.out.println(value);
    }

    // Get first value before sorting
    String firstValueBeforeSorting = driver.findElement(
            By.xpath("//table//tbody/tr[1]/td[1]")
    ).getText();

    System.out.println(
            "First value before sorting: " + firstValueBeforeSorting
    );

    // Click first column header
    driver.findElement(
            By.xpath("//table//thead/tr/th[1]")
    ).click();

    // Get first value after sorting
    String firstValueAfterSorting = driver.findElement(
            By.xpath("//table//tbody/tr[1]/td[1]")
    ).getText();

    System.out.println(
            "First value after sorting: " + firstValueAfterSorting
    );

    // Validate sorting changed the first value
    Assert.assertNotEquals(
            firstValueBeforeSorting,
            firstValueAfterSorting,
            "Table sorting did not change the order"
    );
}
}