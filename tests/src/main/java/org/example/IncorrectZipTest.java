package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class IncorrectZipTest extends Main{
    String expectedErrorMessage = ("Please enter a valid 5 digit ZIP code.");

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
        inputIntoZipBox("123456");
        checkAlert();
    }

    //check using zipcode with less than 5 digits
    @Test
    public void zipLessThanFive(){
        inputIntoZipBox("1234");
        checkAlert();
    }

    //check using letters
    @Test
    public void zipRandomLetters(){
        inputIntoZipBox("abcde");
        checkAlert();
    }

    //check using random symbols
    @Test
    public void zipRandomSymbols(){
        inputIntoZipBox("!@#$%");
        checkAlert();
    }
}
