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
        fillLastName("Test1");
        fillFirstName("Test2");
        fillDateBirth("12/12/1990");
        fillMiddleName("Test3");
        fillRegion("Kyivska");
        fillFST("Dinamo");
        fillTrainer("Test");
        selectAge("Junior");
        fillStyle("FS");
        selectYear("2015");
        selectCard("Produced");
    }

    private void selectCard(String card){
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.card_state']/select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals(card)){
                item.click();
            }
        }
    }

    private void selectYear(String year) {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.expires']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals(year)){
                item.click();
            }
        }
    }

    private void fillStyle(String style) {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.style']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals(style)){
                item.click();
            }
        }
    }

    private void selectAge(String age) {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.lictype']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals(age)){
                item.click();
            }
        }
    }

    private void fillTrainer(String trainer) {
        driver.findElement(By.xpath("//*[@value='wr.trainer1']//input[@placeholder='Trainer']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.trainer1']//input[@placeholder='Trainer']")).sendKeys(trainer);
    }

    private void fillFST(String fst) {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.fst1']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals(fst)){
                item.click();
            }
        }
    }

    private void fillRegion(String region) {
        List<WebElement> list = driver.findElements(By.xpath("//*[@value='wr.region1']//select/option"));
        for (WebElement item:list){
            if (item.getAttribute("label").equals(region)){
                item.click();
            }
        }
    }

    private void fillMiddleName(String middle) {
        driver.findElement(By.xpath("//*[@value='wr.mname']//input[@placeholder='Middle name']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.mname']//input[@placeholder='Middle name']")).sendKeys(middle);
    }

    public void fillLastName(String last){
        driver.findElement(By.xpath("//*[@value='wr.lname']//input[@placeholder='Last name']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.lname']//input[@placeholder='Last name']")).sendKeys(last);
    }

    public void fillFirstName(String first){
        driver.findElement(By.xpath("//*[@value='wr.fname']//input[@placeholder='First name']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.fname']//input[@placeholder='First name']")).sendKeys(first);
    }

    public void fillDateBirth(String date){
        driver.findElement(By.xpath("//*[@value='wr.dob']//input[@placeholder='Date of Birth']")).clear();
        driver.findElement(By.xpath("//*[@value='wr.dob']//input[@placeholder='Date of Birth']")).sendKeys(date);
    }

    public void confirmCreation(){
        driver.findElement(By.xpath("//div[@class='buttons']//*[contains(@ng-click,'save()')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@uploader='photoUploader']")));
    }
}
