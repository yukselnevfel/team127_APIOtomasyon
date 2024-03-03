package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;

public class Deneme_baseUrlHerOkuApp extends BaseUrlHerOkuApp {

@Test
    public void test01(){


    /*
    - https://restful-booker.herokuapp.com/booking
      endpointine yandaki body’ye sahip bir POST request
      gonderdigimizde donen response’un status code’unun
      200 oldugunu ve “firstname” degerinin “Ahmet”
       oldugunu test edin

   {
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
    "checkin" : "2021-06-01",
    "checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}

     */

    //end point ve request oluştırma
    specHerOkuApp.pathParam("pp1","booking");

    JSONObject rezvTarihiJson=new JSONObject();
    rezvTarihiJson.put("checkin" , "2021-06-01");
    rezvTarihiJson.put("checkout","2021-06-10");

    JSONObject reqBody=new JSONObject();
    reqBody.put("firstname","Ahmet");
    reqBody.put("lastname","Bulut");
    reqBody.put("totalprice" , 500);
    reqBody.put("depositpaid" ,false);
    reqBody.put("bookingdates",  rezvTarihiJson);
    reqBody.put("additionalneeds" ,"wi-fi");


    Response response=given().contentType(ContentType.JSON)
                            .when().spec(specHerOkuApp).body(reqBody.toString())
                            .post("/{pp1}");
    response.prettyPrint();
   // response.then().assertThat().statusCode(200).body("firstname", Matchers.equalTo("Ahmet"));


}
}