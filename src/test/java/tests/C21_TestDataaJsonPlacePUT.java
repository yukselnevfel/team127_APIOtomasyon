package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.JsonPlaceDatas;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_TestDataaJsonPlacePUT extends BaseUrlJsonPlaceUrl {
  /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body (Expected Data) :
            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */

    @Test
    public void test01() {
        //1.adım
        specJsonPlaceHolder.pathParams("pp1", "posts", "pp2", "70");

        JSONObject reqBody = JsonPlaceDatas.JSonDataOlustur(10, 70, "Ahmet", "Merhaba");

        //2.adım
        JSONObject expBody = JsonPlaceDatas.JSonDataOlustur(10, 70, "Ahmet", "Merhaba");

        //3. adım
        Response response = given().contentType(ContentType.JSON)
                .when().spec(specJsonPlaceHolder).body(reqBody.toString())
                .put("{pp1}/{pp2}");

        //4.adım
        JsonPath resJP = response.jsonPath();

        assertEquals(JsonPlaceDatas.basariliSC, response.getStatusCode());
        assertEquals(JsonPlaceDatas.contentType, response.getContentType());
        assertEquals(JsonPlaceDatas.header, response.getHeader("Connection"));
        assertEquals(expBody.getInt("userId"), resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"), resJP.getInt("id"));
        assertEquals(expBody.getString("title"), resJP.getString("title"));
        assertEquals(expBody.getString("body"), resJP.getString("body"));

    }


}
