package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class Main {

    WebDriver driver;
    String projectPath;
    //before method which loads up site (headless)
    @BeforeMethod
    public void loadSite() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);

        //**used to get path to index.html, which will be used by the driver**
        //get current path
        String currentPath = System.getProperty("user.dir");

        //file leading to current path
        File tempFile = new File(currentPath);

        //get parent file of tempfile
        File projectPathFile = tempFile.getParentFile();
        //get parent pathway (same as project)
        projectPath = projectPathFile.getAbsolutePath();
        //concatenate with /index.html
        String indexPath = (projectPath + "/index.html");
        driver.get(indexPath);
    }

    //after method that takes screenshot, saves screenshot into screenshots folder, and closes driver
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(projectPath+ "/screenshots/" + result.getMethod().getMethodName() + ".png"));
        driver.quit();
    }
}
