package pages;

import core.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Валерий on 10.08.2015.
 */
public class CreateSportsManPage extends PageBase {

    public CreateSportsManPage(WebDriver driver){
        this.driver=driver;
    }

    public void fillAllData(){
        fillLastName();
        fillFirstName();
        fillDateBirth();
        fillMiddleName();
        fillRegion();
        fillFST();
        fillTrainer();
        fillAge();
        fillStyle();
        fillYear();
        selectCard();
    }

    private void selectCard() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.card_state']/select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals()){
                item.click();
            }
        }
    }

    private void fillYear() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.expires']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals()){
                item.click();
            }
        }
    }

    private void fillStyle() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.style']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals()){
                item.click();
            }
        }
    }

    private void fillAge() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.lictype']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals()){
                item.click();
            }
        }
    }

    private void fillTrainer() {
        driver.findElement(By.xpath("//*[@value='wr.trainer1']//input[@placeholder='Trainer']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.trainer1']//input[@placeholder='Trainer']")).sendKeys();
    }

    private void fillFST() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.expires']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals()){
                item.click();
            }
        }
    }

    private void fillRegion() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.expires']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals()){
                item.click();
            }
        }
    }

    private void fillMiddleName() {
        driver.findElement(By.xpath("//*[@value='wr.mname']//input[@placeholder='Middle name']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.mname']//input[@placeholder='Middle name']")).sendKeys();
    }

    public void fillLastName(){
        driver.findElement(By.xpath("//*[@value='wr.lname']//input[@placeholder='Last name']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.lname']//input[@placeholder='Last name']")).sendKeys();
    }

    public void fillFirstName(){
        driver.findElement(By.xpath("//*[@value='wr.fname']//input[@placeholder='First name']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.fname']//input[@placeholder='First name']")).sendKeys();
    }

    public void fillDateBirth(){
        driver.findElement(By.xpath("//*[@value='wr.dob']//input[@placeholder='Date of Birth']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.dob']//input[@placeholder='Date of Birth']")).sendKeys();
    }

    public void confirmCreation(){
        driver.findElement(By.xpath("//div[@class='buttons']//*[contains(@ng-click,'save()')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@uploader='photoUploader']")));
    }
}
