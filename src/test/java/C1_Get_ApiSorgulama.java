import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiSorgulama {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizdedonen Response’un,
  status code’unun 200,
 ve content type’inin application/json; charset=utf-8,
 ve Server isimli Header’in degerinin Cowboy,
 ve status Line’in HTTP/1.1 200 OK
 ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

    // 1- Request body ve end-point hazirlama
    // 2- Expected Data hazirlama
    // 3- Request gönderip, dönen response'i kaydetme
    // 4- Assertion
    @Test
    public void get01(){
        // 1-Endpoint belirlenerek hazirlanir
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2-Gerekli ise Expected data hazirlanir
        //3- Request gönderip, dönen response'i kaydetme
        Response response=given().when().get(url);
        //response.prettyPrint();
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Content type: "+response.getContentType());
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Header/Server: "+response.getHeader("Server"));
        System.out.println("Test time"+response.getTime()+"ms");

}

}
