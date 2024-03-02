package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.runner.Request;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {
    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine
    bir GET request yolladigimizda
        donen Response'in
            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sindeki
            employees sayisinin 24
            ve employee'lerden birinin "Ashton Cox"
            ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
 */
  @Test
    public void test10(){

      // end point ve request body oluştur
      String url="http://dummy.restapiexample.com/api/v1/employees";

      //Expected data hazırlama

      //Request gönderip response'ı kaydet
      Response response  = given().when().get(url);


      //Assert
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
            .body("data.id",hasSize(24),
                    "data.employee_name",hasItem("Ashton Cox"),
                    "data.employee_age",hasItems(61,21,35));
  }


  }

