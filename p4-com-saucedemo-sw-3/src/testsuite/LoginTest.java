package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        driver.navigate().refresh();
        // Enter “standard_user”username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // * Enter “secret_sauce”password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //* Click on ‘LOGIN’button
        driver.findElement(By.id("login-button")).click();

        //* Verify the text “PRODUCTS”
        getTextFromElement(By.xpath("//*[@class='title']"));
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//*[@class='title']")).getText();
        assertEquals("Try again", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        //* Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //* Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //* Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        //* Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='inventory_list']"));

        //getTextFromElement(By.xpath("//*[@class='inventory_list']"));
        //String expectedList = "productList";
        //String actualList = driver.findElement(By.xpath("//*[@class='inventory_list']")).getText();
        //Assert.assertEquals("six products are not displayed on page", products.size()==6);
        //assertEquals("Six products are not displayed on page",expectedList, actualList);

        WebElement productsContainer = driver.findElement(By.xpath("//*[@class='inventory_list']"));
        int numberOfProducts = productsContainer.findElements(By.xpath("//*[@class='inventory_list']")).size();
        //Verify that the number of products is 6
        assert numberOfProducts == 6 : "six products are not displayed on page";

        //to check
        System.out.println("Test Passed! Six products are displayed on the page.");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
