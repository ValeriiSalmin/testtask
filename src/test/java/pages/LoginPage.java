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
public class LoginPage extends PageBase{

    String URL = "http://streamtv.net.ua/base/";
    String login = "auto";
    String password = "test";

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait){
        this.driver=driver;
        this.webDriverWait=webDriverWait;
        open(URL);
        Assert.assertTrue(driver.getCurrentUrl().equals(URL+"login"));
    }

    public void login(){
        //driver.get(URL);
        driver.findElement(By.xpath("//*[@id='username']//input[@placeholder='Login']")).clear();
        driver.findElement(By.xpath("//*[@id='username']//input[@placeholder='Login']")).sendKeys(login);
        driver.findElement(By.xpath("//*[@name='loginform']//*[@type='password']//*[@type='password']")).clear();
        driver.findElement(By.xpath("//*[@name='loginform']//*[@type='password']//*[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@name='loginform']/button[contains(text(),'Login')]")).click();
        webDriverWait.until(ExpectedConditions.urlToBe(URL));
    }
}
