package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    public static WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver =new ChromeDriver();
    }
    @AfterMethod
    public void driverClose(){
        if(driver!=null) {
            driver.quit();
        }
    }

}
