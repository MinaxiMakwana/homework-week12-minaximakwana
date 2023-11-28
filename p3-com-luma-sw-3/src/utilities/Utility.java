package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {

    //click method
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    //sendKeys methods
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    //getText method
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

}
