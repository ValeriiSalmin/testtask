package core;

import web_driver_initial.DriverInitial;

/**
 * Created by Валерий on 03.08.2015.
 */
public class PageBase extends DriverInitial{

    public void open(String URL){
        driver.get(URL);
    }
}
