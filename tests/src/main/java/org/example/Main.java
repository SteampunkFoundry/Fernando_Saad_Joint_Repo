package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Main implements TestInterface {
    public WebDriver loadSite() {
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
        driver.get(indexPath);
        return driver;
    }
}
