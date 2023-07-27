package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class OpenSiteTest extends Main{
    @Test
    public void functionalTest() {

        WebDriver driver = loadSite();

        //verify the title appears correctly, which will happen if
        //it opens
        assertEquals(driver.getTitle(), "My Project for Team Punk");

        //Close the browser
        driver.quit();
    }
}