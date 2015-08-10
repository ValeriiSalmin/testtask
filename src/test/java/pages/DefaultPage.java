package pages;

import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Валерий on 10.08.2015.
 */
public class DefaultPage extends PageBase {

    String URL="http://streamtv.net.ua/base/";

    public DefaultPage(WebDriver driver, WebDriverWait webDriverWait){
        this.driver=driver;
        this.webDriverWait=webDriverWait;
        if (!driver.getCurrentUrl().equals(URL)){
            open(URL);
        }
        Assert.assertTrue(driver.getCurrentUrl().equals(URL));
    }

    public void createNewSportsMan(){
        driver.findElement(By.xpath("//button[@ng-click='newWrestler()']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@ng-click='delete()']")));
    }

    public void searchSportsMan(String searchQuery){
        driver.findElement(By.xpath("//input[@ng-model='searchFor']")).clear();
        driver.findElement(By.xpath("//input[@ng-model='searchFor']")).sendKeys(searchQuery);
        driver.findElement(By.xpath("//button[@ng-click='searchWrestler(searchFor)']")).click();
    }
}
