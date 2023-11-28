package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){

        //* Mouse Hover on Men Menu //xpath //*[@id="ui-id-5"]/span[2]
        WebElement menMenu = driver.findElement(By.id("ui-id-5"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(menMenu).build().perform();

        //* Mouse Hover on Bottoms //xpath //*[@id="ui-id-18"]/span[2]
        WebElement Bottoms = driver.findElement(By.id("ui-id-18"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(Bottoms).build().perform();

        //* Click on Pants //xpath //*[@id="ui-id-23"]/span
        driver.findElement(By.id("ui-id-23")).click();

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        WebElement cronusYogaPant = driver.findElement(By.xpath("//*[@class='product-item-link']"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(cronusYogaPant).build().perform();

        driver.findElement(By.id("option-label-size-143-item-175")).click();

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        WebElement cronusYogaPant1 = driver.findElement(By.xpath("//*[@class='product-item-link']"));
        Actions action4 = new Actions(driver);
        action4.moveToElement(cronusYogaPant1).build().perform();

        driver.findElement(By.id("option-label-color-93-item-49")).click();

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        WebElement cronusYogaPant2 = driver.findElement(By.xpath("//*[@class='product-item-link']"));
        Actions action5 = new Actions(driver);
        action5.moveToElement(cronusYogaPant2).build().perform();

        driver.findElement(By.xpath("//*[@class='action tocart primary']")).click();

        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        getTextFromElement(By.id("message-success"));
        String expectedMsgDisplay = "You added Cronus Yoga Pant to your shopping cart";
        String actualMsgDisplay = driver.findElement(By.id("message-success")).getText();
        Assert.assertEquals("Add to your shopping cart was unsuccessful", expectedMsgDisplay, actualMsgDisplay);

        //* Click on ‘shopping cart’ Link into message
        driver.findElement(By.linkText("shopping cart")).click();

        //* Verify the text ‘Shopping Cart.’
        driver.findElement(By.id("page-title-wrapper")).getText();

        //* Verify the product name ‘Cronus Yoga Pant’
        getTextFromElement(By.linkText("Cronus Yoga Pant"));
        String expectedText = "product name ‘Cronus Yoga Pant";
        String actualText = driver.findElement(By.linkText("Cronus Yoga Pant")).getText();
        Assert.assertEquals("chgeck if the product name is ‘Cronus Yoga Pant", expectedText, actualText);

        //* Verify the product size ‘32’
        getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        String expectedSize = "product size is 32";
        String actualSize = driver.findElement(By.linkText("//dd[contains(text(),'32')]")).getText();
        Assert.assertEquals("cgeck if the product size is correct", expectedText, actualText);

        //* Verify the product colour ‘Black’
        getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        String expectedColour = "product colour is Black";
        String actualColour = driver.findElement(By.linkText("//dd[contains(text(),'Black')]")).getText();
        Assert.assertEquals("check if the product colour is correct", expectedColour, actualColour);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
