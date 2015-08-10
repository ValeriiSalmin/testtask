package api_tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import static com.jayway.restassured.RestAssured.basic;
import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Валерий on 10.08.2015.
 */
public class CRUDSportsmanTest  {

    String myJSON="{\"new\":true,\"id_wrestler\":0,\"attaches\":[],\"card_state\":\"1\",\"lname\":\"1111\",\"fname\":\"111\",\"dob\":\"12-12-2000\"\n" +
            ",\"mname\":\"111\",\"region1\":\"2\",\"fst1\":\"2\",\"style\":\"1\",\"expires\":\"2016\",\"lictype\":\"1\"}";

    //HttpClient httpClient = new HttpClient();
    String loginJSON="{\"username\":\"auto\",\"password\":\"test\"}";

    @BeforeTest
    public void login(){
        Response r = given().contentType("application/json").params("Connection","keep-alive").body(loginJSON).when().post("http://streamtv.net.ua/base/php/login.php");
//        @BeforeTest
//        public void basicAuthentication() throws Exception {
//            given().auth().basic("jetty", "jetty").expect().statusCode(200).when().post("http://streamtv.net.ua/base/php/login.php");
//        }
        String body = r.getBody().asString();
        System.out.println(body);
    }
//@BeforeTest
//public void setUp() {
   // RestAssured.authentication = basic("auto","test");
   // given().auth().basic("auto", "test").post("http://someWebsite/reserveRide").
//}

    @Test
    public void createSportsman() {

        //Response r1 =  given().auth().basic("auto", "test").contentType("application/json").body(myJSON).when().post("http://streamtv.net.ua/base/php/wrestler/create.php");

        Response r1 = given().contentType("application/json").body(myJSON).when().post("http://streamtv.net.ua/base/php/wrestler/create.php");
        //System.out.println(r);
        String body = r1.getBody().asString();
        System.out.println(body);
    }
}
