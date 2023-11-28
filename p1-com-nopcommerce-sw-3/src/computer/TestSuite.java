package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TestSuite extends Utility {

    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){

        //1.1 Click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//option[normalize-space()='Name: Z to A']"));
        //1.4 Verify the Product will arrange in Descending order
        String actualResult;
        String expectedResult = "Products are sorted by Z to A order";
        actualResult = getTextFromElement(By.xpath("//div[@class='page-body']"));
        Assert.assertEquals("Products are not sorted by Z to A order", expectedResult, actualResult);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='item-grid']//button[1]"));
        //2.5 Verify the Text "Build your own computer"
        getTextFromElement(By.xpath("//h1"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.xpath("//option[contains(text(),'2.2 GHz Intel Pentium Dual-Core E2200')]"));
        //2.7.Select "8GB [+$60.00]" using Select class
        clickOnElement(By.xpath("//option[contains(text(),'8GB [+$60.00]"));
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]
        clickOnElement(By.id("product_attribute_4_9"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));
        //2.11 Verify the price "$1,475.00"
        getTextFromElement(By.id("price-value-1"));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar; After that close the bar clicking on the cross button
        getTextFromElement(By.xpath("//p[@class='content']"));
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        WebElement MouseHover = driver.findElement(By.xpath("//div[@class='bar-notification success']"));
        Actions action = new Actions(driver);
        action.moveToElement(MouseHover).perform();
        //2.15 Verify the message "Shopping cart"
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.id("itemquantity11225"));
        clickOnElement(By.id("updatecart"));
        //2.17 Verify the Total"$2,950.00"
        getTextFromElement(By.xpath("//td[@class='subtotal']"));
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        getTextFromElement(By.xpath("//h1"));
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        //2.22 Fill the all mandatory field
        //tried using sendTextToElement from Utility class but was getting error
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("abc");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("xyz");
        driver.findElement(By.xpath("BillingNewAddress_Email")).sendKeys("abcxyz@gmail.com");
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("British Indian Ocean Territory");
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("10 downing street");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("SW1A 2AB");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("12365 879 237");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//option[@value='MasterCard']"));
        //2.28 Fill all the details
        driver.findElement(By.id("CardholderName")).sendKeys("abc");
        driver.findElement(By.id("CardNumber")).sendKeys("1234 1234 1234 1234");
        driver.findElement(By.xpath("//option[normalize-space()='12']"));
        driver.findElement(By.xpath("//option[@value='2024']"));
        driver.findElement(By.id("CardCode")).sendKeys("123");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        getTextFromElement(By.xpath("//li[normalize-space()='Wrong card number']"));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        getTextFromElement(By.xpath("//span[normalize-space()='next Day Air']"));
        String expectedShippingMethod = "Shipping Method” is “Next Day Air";
        String actualShippingMethod = driver.findElement(By.xpath("//span[normalize-space()='next Day Air']")).getText();
        Assert.assertEquals("Check again Its not correct method", expectedShippingMethod, actualShippingMethod);

        //2.33 Verify Total is “$2,950.00”
        getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
        String expectedTotal2950 = "Total is “$2,950.00";
        String actualTotal2950 = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]")).getText();
        Assert.assertEquals("Check again Its not correct method", expectedTotal2950, actualTotal2950);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You”
        getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        String expectedThankYou =  "Thank You";
        String actualThankYou = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']")).getText();
        Assert.assertEquals("Check again", expectedThankYou, actualThankYou);

        //2.36 Verify the message “Your order has been successfully processed!”
        getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        String expectedProcessed =  "Your order has been successfully processed!";
        String actualProcessed = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
        Assert.assertEquals("Check again", expectedProcessed, actualProcessed);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.37 Verify the text “Welcome to our store”
        getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        String expectedVerifyUrl =  "Welcome to our store";
        String actualVerifyUrl = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
        Assert.assertEquals("Check again Its not correct output", expectedVerifyUrl, actualVerifyUrl);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
