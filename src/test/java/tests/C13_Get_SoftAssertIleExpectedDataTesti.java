package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
       /*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde
   donen response'un asagidaki gibi oldugunu test edin.
       Response Body
       {
           "status":"success",
           "data":{
                   "id":3,
                   "employee_name":"Ashton Cox",
                   "employee_salary":86000,
                   "employee_age":66,
                   "profile_image":""
                   },
           "message":"Successfully! Record has been fetched."
       }
*/
    @Test
    public void softAssertTesti(){
        // endpoint ve request body hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        // expected body hazirla
        JSONObject expBody= new JSONObject();
        JSONObject data=new JSONObject();
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        expBody.put("status","success");
        expBody.put("data",data);
        expBody.put("message","Successfully! Record has been fetched.");

        //Request gönder response kayıt
        Response response=given().when().get(url);

        // Assertion
        JsonPath respJP= response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(respJP.get("status"),expBody.get("status"));






        softAssert.assertAll();

    }
}
