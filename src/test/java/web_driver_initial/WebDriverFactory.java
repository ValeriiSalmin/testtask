package web_driver_initial;

import core.BrowserTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Arrays;

/**
 * Created by Валерий on 09.08.2015.
 */
public class WebDriverFactory {

    public static WebDriver getWebDriver(BrowserTypes browserTypes){
        switch (browserTypes){
            case FIRE_FOX:
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile ffprofile = profile.getProfile("SELENIUM");
                return new FirefoxDriver(ffprofile);
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
                return new ChromeDriver(chromeOptions);
            case IE:
                return new InternetExplorerDriver();
            default:
                throw new IllegalArgumentException("Browser is not supported"+browserTypes.name());
        }
    }
}
