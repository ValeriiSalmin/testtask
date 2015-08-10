package ui_tests;

import com.jayway.restassured.RestAssured;
import core.TestBase;
import org.testng.annotations.Test;
import pages.CreateSportsManPage;
import pages.DefaultPage;
import pages.LoginPage;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Валерий on 03.08.2015.
 */
public class CRUDSportsmenTest extends TestBase{

//    public void simpleExample(){
//        expect().body("title", equalTo("Hello world!")).when().get("http://localhost:64217/wp-json.php/posts/1");
//    }

    @Test
    public void createSportsMan(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        DefaultPage defaultPage = new DefaultPage(driver);
        defaultPage.createNewSportsMan();
        CreateSportsManPage createSportsManPage = new CreateSportsManPage(driver);
        createSportsManPage.fillAllData();
        createSportsManPage.confirmCreation();
    }


}
