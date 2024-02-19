import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
     donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
  Response body :
{
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */
    @Test
    public void expectedBodyTesti(){
        // end point ve body hazirla
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //Expected body hazırla
        JSONObject expBody=new JSONObject();
        expBody.put("userId", 3);
        expBody.put( "id", 22);
        expBody.put("title", "dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita ear\n" +
                "            um mollitia molestiae aut atque rem suscipit\\nnam impedit esse");
        // Request gönder ve response kaydet
        Response response= given().when().get(url);
        //Assertion
        JsonPath respJsonPath= response.jsonPath();

    }
}