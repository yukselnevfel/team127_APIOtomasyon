import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.*;

public class Deneme {

    @Test
    public void test01(){
               /*
C1_Get_ApiSorgulama
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application/json; charset=utf-8, ve
Server isimli Header'in degerinin Cowboy,
ve status Line'in HTTP/1.1 200 OK
ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */


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
    }

    @Test
    public void test05(){
        //   https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        //   donen Response'in
        //   status code'unun 200,
        //   ve content type'inin application/json; charset=utf-8,
        //   ve response body'sinde bulunan userId'nin 5,
        //   ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.
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
