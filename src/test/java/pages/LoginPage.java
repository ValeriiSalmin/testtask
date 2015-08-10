package pages;

import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Валерий on 10.08.2015.
 */
public class LoginPage extends PageBase{

    String URL = "http://streamtv.net.ua/base/login";
    String login = "auto";
    String password = "test";

    public LoginPage(WebDriver driver){
        this.driver=driver;
        open(URL);
        Assert.assertTrue(driver.getCurrentUrl().equals(URL));
    }

    public void login(){
        //driver.get(URL);
        driver.findElement(By.xpath("//*[@id='username']//input[@placeholder='Login']")).clear();
        driver.findElement(By.xpath("//*[@id='username']//input[@placeholder='Login']")).sendKeys();
        driver.findElement(By.xpath("//*[@name='loginform']//*[@type='password']//*[@type='password']")).clear();
        driver.findElement(By.xpath("//*[@name='loginform']//*[@type='password']//*[@type='password']")).sendKeys();
        driver.findElement(By.xpath("//*[@name='loginform']/button[contains(text(),'Login')]")).click();
    }
}
