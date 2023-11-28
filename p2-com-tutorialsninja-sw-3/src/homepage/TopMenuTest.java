package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void selectMenu(String menu){
        //1.2 This method should click on the menu whatever name is passed as parameter. Write the following Test:
        clickOnElement(By.xpath("//a[text()='"+ menu +"']"));
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
            driver.navigate().refresh();
//        1.1 Mouse hover on “Desktops” Tab and click
        WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(desktops).build().perform();

//        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");

//        1.3 Verify the text ‘Desktops’
        getTextFromElement(By.xpath("//h2"));
        String expectedMsg = "Desktops";
        String actualMsg = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals("Try again", expectedMsg, actualMsg);

    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
//        2.1 Mouse hover on “Laptops & Notebooks” Tab and click

//        2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”

//        2.3 Verify the text ‘Laptops & Notebooks’

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
//        3.1 Mouse hover on “Components” Tab and click

//        3.2 call selectMenu method and pass the menu = “Show All Components”

//        3.3 Verify the text ‘Components’

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
