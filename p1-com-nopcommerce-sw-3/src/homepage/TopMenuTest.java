package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    @Test
    public void selectMenu(String menu){

        //1.2 This method should click on the menu whatever name is passed as parameter.
        //System.out.println(menu); // for try
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='"+ menu +"']"));
        //varify the heading eg comoputers //h1 - + get text
        //assertion
        getTextFromElement(By.xpath("//h1"));
        String expectedMsg = "Computers";
        String actualMsg = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Try again", expectedMsg, actualMsg);

        driver.navigate().to(baseUrl);
    }

     //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation(){
        //List<WebElement> productList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']")); // Trying this method

        String computers = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        selectMenu(computers);

        String electronics = getTextFromElement(By.xpath("//h1[normalize-space()='Electronics']"));
        selectMenu(electronics);

        String apparel = getTextFromElement(By.xpath("///h1[normalize-space()='Apparel']"));
        selectMenu(apparel);

        String digiDownloads = getTextFromElement(By.xpath("///h1[normalize-space()='Digital downloads']"));
        selectMenu(digiDownloads);

        String books = getTextFromElement(By.xpath("///h1[normalize-space()='Books']"));
        selectMenu(books);

        String jewelry = getTextFromElement(By.xpath("///h1[normalize-space()='Jewelry']"));
        selectMenu(jewelry);

        String giftCards = getTextFromElement(By.xpath("///h1[normalize-space()='Gift Cards']"));
        selectMenu(giftCards);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
