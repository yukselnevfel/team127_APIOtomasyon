import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C6_Post_ResponseBodyTesti {
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
@Test
    public void postResponseBodyTesti(){
//1--endpoint ve request body hazirla.
    String url="https://jsonplaceholder.typicode.com/posts";

    JSONObject reqBody=new JSONObject();
    reqBody.put("title","API");
    reqBody.put("body","API ogrenmek ne guzel");
    reqBody.put("userId",10);

    //2--Expected data olustur


    //3--Request gönderip dönen response 'ı kaydet.

    Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
    //4--Assertion islemini yap
    response.then().assertThat()
            .statusCode(201)
            .contentType("application/json")
           // .contentType(ContentType.JSON) böyle de kullanılabilir!
            .body("title",equalTo("API"))
            .body("userId",lessThan(100))
            .body("body",containsString("API"));



}

}

