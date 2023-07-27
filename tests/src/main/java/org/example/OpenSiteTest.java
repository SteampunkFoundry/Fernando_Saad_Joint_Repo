package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class OpenSiteTest {
    @Test
    public void functionalTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //**used to get path to index.html, which will be used by the driver**
        //get current path
        String currentPath = System.getProperty("user.dir");

        //file leading to current path
        File tempFile = new File(currentPath);

        //get parent file of tempfile
        File projectPathFile = tempFile.getParentFile();
        //get parent pathway (same as project)
        String projectPath = projectPathFile.getAbsolutePath();
        //concatenate with /index.html
        String indexPath = (projectPath + "/index.html");

        //get index.html
        driver.get(indexPath);

        //verify the title appears correctly, which will happen if
        //it opens
        assertEquals(driver.getTitle(), "My Project for Team Punk");

        //Close the browser
        driver.quit();
    }
}