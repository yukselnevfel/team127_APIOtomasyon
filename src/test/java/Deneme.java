import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Deneme {

    @Test
    public void test01(){
/*
http://dummy.restapiexample.com/api/v1/employees url 'ine bir GET request yollayin.
dönen response'in
- status code'unun 200,
-content type'nin Aplication.JSON,
-response body'indeki employees sayisinin 24
-ve eployee'lerden birinin "Ashton Cox"
-ve de girilen yaslar icinde 61,21,35 degerinin olduğunu test edin.
 */

        //1 endpoint ve body hazırla
        String url="http://dummy.restapiexample.com/api/v1/employees";
        //2 Expected data hazirla
        //3 Request gönderip dönen response'ı kaydet

        Response response= given().when().get(url);

    }
}
