package org.example;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class IncorrectZipTest extends Main {
    WebDriver driver;
    String expectedErrorMessage = ("Please enter a valid 5 digit ZIP code.");

    //reduce redundancy and repeating code
    //NEED TO load call method "loadSite()" before you call this
    public void inputIntoZipBox(String input){
        //find the zipcode input box and input the parameter
        WebElement zipCodeBox = driver.findElement(By.id("zipCode"));
        zipCodeBox.sendKeys(input);
        //click the button
        WebElement submitButton = driver.findElement(By.cssSelector("body > button"));
        submitButton.click();
    }

    public void checkAlert(){
        String actualErrorMessage = driver.switchTo().alert().getText();
        assertEquals(expectedErrorMessage, actualErrorMessage);
        driver.switchTo().alert().accept();
    }

    //check using zipcode larger than 5 digits
    @Test
    public void zipGreaterThanFive() {
        driver = loadSite();
        inputIntoZipBox("123456");
        checkAlert();
        driver.quit();
    }

    //check using zipcode with less than 5 digits
    @Test
    public void zipLessThanFive(){
        driver = loadSite();
        inputIntoZipBox("1234");
        checkAlert();
        driver.quit();
    }

    //check using letters
    @Test
    public void zipRandomLetters(){
        driver = loadSite();
        inputIntoZipBox("abcde");
        checkAlert();
        driver.quit();
    }

    //check using random symbols
    @Test
    public void zipRandomSymbols(){
        driver = loadSite();
        inputIntoZipBox("!@#$%");
        checkAlert();
        driver.quit();
    }
}
