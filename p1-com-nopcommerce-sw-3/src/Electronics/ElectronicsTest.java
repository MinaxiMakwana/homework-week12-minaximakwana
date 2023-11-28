package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    static String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void  verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

//        1.1 Mouse Hover on “Electronics” Tab
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(electronics).build().perform();

//        1.2 Mouse Hover on “Cell phones” and click

        WebElement cellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(cellPhones).build().perform();

//        1.3 Verify the text “Cell phones”

        getTextFromElement(By.xpath("//h1"));
        String expectedMsg = "Cell phones";
        String actualMsg = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Try again", expectedMsg, actualMsg);

    }
@Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){

//        2.1 Mouse Hover on “Electronics” Tab
        WebElement cellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(cellPhones).build().perform();

//        2.2 Mouse Hover on “Cell phones” and clic
        WebElement CellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions action4 = new Actions(driver);
        action4.moveToElement(CellPhones).build().perform();

//        2.3 Verify the text “Cell phones”
        getTextFromElement(By.xpath("//h1"));
        String expectedMsg = "Cell phones";
        String actualMsg = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Try again", expectedMsg, actualMsg);

//        2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
//        2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//a[normalize-space()='Nokia Lumia 1020']"));
//        2.6 Verify the text “Nokia Lumia 1020”
        getTextFromElement(By.xpath("//h1"));
        String expectedResult = "Nokia Lumia 1020";
        String actualResult = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Try again", expectedResult, actualResult);
//        2.7 Verify the price “$349.00”
        getTextFromElement(By.id("price-value-20"));
        String expectedPrice = "Nokia Lumia 1020";
        String actualPrice = driver.findElement(By.id("price-value-20")).getText();
        Assert.assertEquals("Try again", expectedPrice, actualPrice);
//        2.8 Change quantity to 2
        driver.findElement(By.id("product_enteredQuantity_20")).sendKeys("2");
//        2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));
//        2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
//        After that close the bar clicking on the cross button.
        getTextFromElement(By.xpath("//p[@class='content']"));
        String expectedProductAddedToCart = "The product has been added to your shopping cart";
        String actualProductAddedToCart = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals("Try again", expectedProductAddedToCart, actualProductAddedToCart);

        clickOnElement(By.xpath("//span[@title='Close']"));

//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement MouseHover = driver.findElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Actions action = new Actions(driver);
        action.moveToElement(MouseHover).perform();

//        2.12 Verify the message "Shopping cart"
        getTextFromElement(By.xpath("//a[normalize-space()='shopping cart']"));
        String expectedShoppingCart = "shopping cart";
        String actualShoppingCart = driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).getText();
        Assert.assertEquals("Try again", expectedShoppingCart, actualShoppingCart);

//        2.13 Verify the quantity is 2
        getTextFromElement(By.id("itemquantity11220"));
        String expectedQty2 = "Quantity is 2";
        String actualQty2 = driver.findElement(By.id("itemquantity11220")).getText();
        Assert.assertEquals("Try again", expectedQty2, actualQty2);

//        2.14 Verify the Total $698.00
        getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        String expectedTotal = "Total price is $698.00";
        String actualTotal = driver.findElement(By.id("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals("Try again", expectedTotal, actualTotal);

//        2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

//        2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

//        2.17 Verify the Text “Welcome, Please Sign In!”
        getTextFromElement(By.xpath("//h1"));
        String expectedSignIn = "Welcome, Please Sign In!";
        String actualSignIn = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Try again", expectedSignIn, actualSignIn);

//        2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

//        2.19 Verify the text “Register”
        getTextFromElement(By.xpath("//h1"));
        String expectedRegister = "Register";
        String actualRegister = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Try again", expectedRegister, actualRegister);

//        2.20 Fill the mandatory fields
        driver.findElement(By.id("FirstName")).sendKeys("abc");
        driver.findElement(By.id("LastName")).sendKeys("xyz");
        driver.findElement(By.xpath("//option[normalize-space()='1']")).sendKeys("01");
        driver.findElement(By.xpath("//option[normalize-space()='January']")).sendKeys("01");
        driver.findElement(By.xpath("//option[@value='2023']")).sendKeys("2023");
        driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Abcd@1234");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Abcd@1234");

//        2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

//        2.22 Verify the message “Your registration completed”
        getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedReg = "Your registration completed";
        String actualReg = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Try again", expectedReg, actualReg);

//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

//        2.24 Verify the text “Shopping card”
        getTextFromElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
        String expectedShoppingCard = "Shopping card";
        String actualShoppingCard = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals("Try again", expectedShoppingCard, actualShoppingCard);

//        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

//        2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

//        2.27 Fill the Mandatory fields
        clickOnElement(By.id("Email"));
        clickOnElement(By.id("Password"));

//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

//        2.30 Click on “CONTINUE”
        clickOnElement(By.id("shippingoption_2"));

//        2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));

//        2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//option[contains(text(),'Visa')]"));

//        2.33 Fill all the details
    driver.findElement(By.id("CardholderName")).sendKeys("abc");
    driver.findElement(By.id("CardNumber")).sendKeys("1234 1234 1234 1234");
    driver.findElement(By.xpath("//option[contains(text(),'01')]")).sendKeys("01");
    driver.findElement(By.xpath("//option[contains(text(),'2024')]")).sendKeys("2024");
    driver.findElement(By.id("CardCode")).sendKeys("111");

//        2.34 Click on “CONTINUE”
    clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

//        2.35 Verify “Payment Method” is “Credit Card”
    getTextFromElement(By.xpath("//span[normalize-space()='Credit Card']"));
    String expectedCc = "Credit Card";
    String actualCc = driver.findElement(By.xpath("//span[normalize-space()='Credit Card']")).getText();
    Assert.assertEquals("Check again Its not correct method", expectedCc, actualCc);

//        2.36 Verify “Shipping Method” is “2nd Day Air”
    getTextFromElement(By.xpath("//span[normalize-space()='2nd Day Air']"));
    String expectedShippingMethod = "Shipping Method” is “2nd Day Air";
    String actualShippingMethod = driver.findElement(By.xpath("//span[normalize-space()='2nd Day Air']")).getText();
    Assert.assertEquals("Check again Its not correct method", expectedShippingMethod, actualShippingMethod);

//        2.37 Verify Total is “$698.00”
    getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
    String expectedTotal698 = "Total is “$698.00";
    String actualTotal698 = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]")).getText();
    Assert.assertEquals("Check again Its not correct method", expectedTotal698, actualTotal698);

//        2.38 Click on “CONFIRM”
    clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

//        2.39 Verify the Text “Thank You”
    getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
    String expectedThankYou =  "Thank You";
    String actualThankYou = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText();
    Assert.assertEquals("Check again", expectedThankYou, actualThankYou);

//        2.40 Verify the message “Your order has been successfully processed!”
    getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
    String expectedProcessed =  "Your order has been successfully processed!";
    String actualProcessed = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
    Assert.assertEquals("Check again", expectedProcessed, actualProcessed);

//        2.41 Click on “CONTINUE”
    clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

//        2.42 Verify the text “Welcome to our store”
    getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
    String expectedWelcome =  "Welcome to our store";
    String actualWelcome = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
    Assert.assertEquals("Check again Its not correct output", expectedWelcome, actualWelcome);

//        2.43 Click on “Logout” link
    clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

//        2.44 Verify the URL is “https://demo.nopcommerce.com/
    getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
    String expectedVerifyUrl =  "Welcome to our store";
    String actualVerifyUrl = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
    Assert.assertEquals("Check again Its not correct output", expectedVerifyUrl, actualVerifyUrl);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
