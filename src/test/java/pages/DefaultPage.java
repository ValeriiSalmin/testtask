package pages;

import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Валерий on 10.08.2015.
 */
public class DefaultPage extends PageBase {

    String URL="http://streamtv.net.ua/base/";

    public DefaultPage(WebDriver driver){
        this.driver=driver;
        if (!driver.getCurrentUrl().equals(URL)){
            open(URL);
        }
        Assert.assertTrue(driver.getCurrentUrl().equals(URL));
    }

    public void createNewSportsMan(){
        driver.findElement(By.xpath("//button[@ng-click='newWrestler()']")).click();
    }

    public void searchSportsMan(String searchQuery){
        driver.findElement(By.xpath("//input[@ng-model='searchFor']")).clear();
        driver.findElement(By.xpath("//input[@ng-model='searchFor']")).sendKeys(searchQuery);
        driver.findElement(By.xpath("//button[@ng-click='searchWrestler(searchFor)']")).click();
    }
}
