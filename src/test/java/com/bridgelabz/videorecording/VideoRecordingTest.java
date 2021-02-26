
package com.bridgelabz.videorecording;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoRecordingTest {
    WebDriver driver;
    ATUTestRecorder recorder;

    @BeforeTest
    public void setUp() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        recorder = new ATUTestRecorder("C:\\Recordings", "Script_Video_" + dateFormat.format(date), false);
        recorder.start();
    }

    @Test
    public void testApp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automate-apps.com/how-to-select-an-option-from-a-drop-down-using-selenium-web-driver/");
        WebElement element = driver.findElement(By.id("month"));
        Select select = new Select(element);
        select.selectByIndex(5);
        Thread.sleep(3000);
        select.selectByVisibleText("Feb");
    }

    @AfterTest
    public void tearDown() throws ATUTestRecorderException {
        driver.quit();
        recorder.stop();
    }
}
