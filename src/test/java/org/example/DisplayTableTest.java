package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


//verify that the table displays upon loading the website
public class DisplayTableTest extends Main {

    @Test
    public void reportTest(){
        WebElement reportNumHeader = driver.findElement(By.cssSelector("body > table > thead > tr > th:nth-child(1)"));
        assertEquals(reportNumHeader.getText(), "Report Number");

        WebElement reportDescHeader = driver.findElement(By.cssSelector("body > table > thead > tr > th:nth-child(2)"));
        assertEquals(reportDescHeader.getText(), "Product Description");

        WebElement reportReasonHeader = driver.findElement(By.cssSelector("body > table > thead > tr > th:nth-child(3)"));
        assertEquals(reportReasonHeader.getText(), "Reason for Recall");
    }

}
