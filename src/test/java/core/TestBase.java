package core;

import org.testng.annotations.AfterSuite;
import web_driver_initial.DriverInitial;

/**
 * Created by Валерий on 03.08.2015.
 */
public class TestBase extends DriverInitial{

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }


}
