package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.*;

public class Deneme {

    @Test
    public void test01(){
               /*
tests.C1_Get_ApiSorgulama
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application/json; charset=utf-8, ve
Server isimli Header'in degerinin Cowboy,
ve status Line'in HTTP/1.1 200 OK
ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */
         //1 end point ve request  body oluşturma
        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2 Expected data hazırlama

        //3  Request gönderip response'ı kaydeder
        Response response=given().when().get(url);
       //response.prettyPrint();
        //Asssert

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");



    }

    @Test
    public void test02(){
               /*
    https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
    gonderdigimizde donen Response'un,
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8
    Server isimli Header'in degerinin Cowboy,
    ve status Line'in HTTP/1.1 200 OK olduğunu assert ediniz.
 */


    }

    @Test
    public void test03(){
        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.

{
"firstname":"Jim",
"additionalneeds":"Breakfast",
"bookingdates":{
               "checkin":"2018-01-01",
               "checkout":"2019-01-01"
               },
"totalprice":111,
"depositpaid":true,
"lastname":"Brown"
}
*/
        JSONObject innerJson=new JSONObject();
        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");

        JSONObject outerJson =new JSONObject();
        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",innerJson);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");

        System.out.println(outerJson);

    }
    @Test
    public void test04(){
        /*
    https://jsonplaceholder.typicode.com/posts/70
     url'ine asagidaki Json formatindaki body ile
        bir PUT request gonderdigimizde
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
        donen Response'un,
        status code'unun 200,
        ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin cloudflare,
        ve status Line'in HTTP/1.1 200 OK olduğunu assert ediniz.
     */

        // end point ve request body hazirla
        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody= new JSONObject();
        reqBody.put( "title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put(  "userId", 10);
        reqBody.put( "id", 70);

        // Expected hazırla

        //Request body gönder ve response' ı kaydet
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
        //response.prettyPrint();

        //Assert
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }

    @Test
    public void test05(){
        //   https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        //   donen Response'in
        //   status code'unun 200,
        //   ve content type'inin application/json; charset=utf-8,
        //   ve response body'sinde bulunan userId'nin 5,
        //   ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.

        // end point ve request body
        String url ="https://jsonplaceholder.typicode.com/posts/44";
        // Expected data

        //Request gönderip response'ı kaydetme
        Response response= given().when().get(url);
response.prettyPrint();
        //Assert

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",
                        equalTo(5),"title",equalTo("optio dolor molestias sit"));



    }

    @Test
    public void test06(){
            /*
https://jsonplaceholder.typicode.com/posts url'ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10
        }
        donen Response'un,
        status code'unun 201,
        ve content type'inin application/json
        ve Response Body'sindeki,
         "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini test edin.
 */
        String url ="https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody= new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        Response response= given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
response.prettyPrint();
        response.then().assertThat().statusCode(201).contentType(ContentType.JSON)
                .body("title",equalTo("API"),"userId",lessThan(100),"body",containsString("API"));


    }

    @Test
    public void test07(){
             /*
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
 gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json, ve response body'sindeki
        "firstname"in, "Susan",
        ve "lastname"in, "Jackson",
        ve "totalprice"in, 612,
        ve "depositpaid"in, false,
     ve "additionalneeds"in, "Breakfast" oldugunu test edin
 */
    }

    @Test
    public void test08(){
            /*
https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye sahip
 bir POST request gonderdigimizde
 {
    "firstname" : "Ahmet",
    "lastname" : "Bulut",
    "totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" :{
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
                },
    "additionalneeds" : "wi-fi"
 }
 donen Response'un,
 status code'unun 200,
 ve content type'inin application-json,
 ve response body'sindeki
 "firstname"in,"Ahmet",
 ve "lastname"in, "Bulut",
 ve "totalprice"in,500,
 ve "depositpaid"in,false,
 ve "checkin" tarihinin 2021-06-01 ve "checkout" tarihinin 2021-06-10
 ve "additionalneeds"in,"wi-fi"
 oldugunu test edin


 */
    }
}
