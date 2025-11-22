package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    @Before
    public void openBrowser()
    {

        //open chrome
        driver = new ChromeDriver();

        //maximize,implicitlyWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        //start point
        driver.get("https://opensource-demo.orangehrmlive.com");

    }


    @After
    public void quitDriver() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }

}
