package web_driver_initial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import ui_tests.TestData;

import java.util.concurrent.TimeUnit;

/**
 * Created by Валерий on 03.08.2015.
 */
public class DriverInitial {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeSuite
    public void setUp(){
        driver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);
        webDriverWait = new WebDriverWait(driver,50);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }


}
