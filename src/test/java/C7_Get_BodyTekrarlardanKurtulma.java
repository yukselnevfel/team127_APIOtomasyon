import io.restassured.response.Response;
import org.testng.annotations.Test;

public class C7_Get_BodyTekrarlardanKurtulma {
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
    @Test
    public void bodyTekrarindanKurtulma(){

        String url="https://restful-booker.herokuapp.com/booking/10";




    }
}
