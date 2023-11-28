package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class WomenTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter(){

        // * Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.id("ui-id-4"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(womenMenu).build().perform();

        //* Mouse Hover on Tops
        WebElement tops = driver.findElement(By.id("ui-id-9"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(tops).build().perform();

        //* Click on Jackets
        //clickOnElement(By.id("ui-id-11")); - it was giving error
        driver.findElement(By.id("ui-id-11")).click();

        //* Select Sort By filter “Product Name”
        clickOnElement(By.xpath("//*[@id=\"sorter\"]/option[2]"));

        //* Verify the products name display in alphabetical order
        getTextFromElement(By.xpath("//*[@class='action sorter-action sort-asc']"));
        String expectedDisplay = "Sort by ascending order";
        String actualDisplay = driver.findElement(By.xpath("//*[@class='action sorter-action sort-asc']")).getText();
        Assert.assertEquals("Try sorting again", expectedDisplay, actualDisplay);
        //Assert.assertTrue(actualDisplay.contains(expectedDisplay));
    }
    public void verifyTheSortByPriceFilter(){

        //* Mouse Hover on Women Menu
        WebElement womenMenu = driver.findElement(By.id("ui-id-4"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(womenMenu).build().perform();

        //* Mouse Hover on Tops
        WebElement tops = driver.findElement(By.id("ui-id-9"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(tops).build().perform();

        //* Click on Jackets
        driver.findElement(By.id("ui-id-11")).click();

        //* Select Sort By filter “Price”
        clickOnElement(By.xpath("//*[@id=\"sorter\"]/option[3]"));

        //* Verify the products price display in Low to High
        getTextFromElement(By.xpath("//*[@class='action sorter-action sort-asc']"));
        String expectedDisplayLowToHigh = "Products price display in Low to High";
        String actualDisplayLowToHigh = driver.findElement(By.xpath("//*[@class='action sorter-action sort-asc']")).getText();
        Assert.assertEquals("Products price display in Low to High", expectedDisplayLowToHigh, actualDisplayLowToHigh);

    }

    @After
    public void tearDown(){
        closeBrowser();
        }

}


////*[@id="sorter"]/option[3]