package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){

        //* Mouse Hover on Gear Menu
        WebElement gear = driver.findElement(By.id("ui-id-6"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(gear).build().perform();

        //* Click on Bags
        //driver.findElement(By.id("ui-id-25")).click();
        clickOnElement(By.id("ui-id-25"));

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.linkText("Overnight Duffle"));

        //* Verify the text ‘Overnight Duffle’


        //* Change Qty 3
        

        //* Click on ‘Add to Cart’ Button.


        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’


        //* Click on ‘shopping cart’ Link into message


        //* Verify the product name ‘Cronus Yoga Pant’


        //* Verify the Qty is ‘3’


        //* Verify the product price ‘$135.00’


        //* Change Qty to ‘5’


        //* Click on ‘Update Shopping Cart’ button


        //* Verify the product price ‘$225.00’



    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
