package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_DeSerializationGET extends BaseUrlDummy {
      /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
        Expected Response Body
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66,f
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void test01(){
        //1 adım end point
        specDummy.pathParams("pp1","employee","pp2","3");

        //2. adım
        Map<String,Object> expBodyMAP= DummyData.mapBodyOlustur();

        //3.adım
        Response response=given().spec(specDummy).when().get("{pp1}/{pp2}");

        Map<String,Object> resMAP=response.as(HashMap.class);//response'ı map e çeviriyoruz!
        //4.Adım Assert
        // donen response’un status code’unun 200,
        //content Type’inin application/json
        //ve body’sinin asagidaki gibi oldugunu test edin.

        assertEquals(DummyData.basariliStatusCode,response.getStatusCode());
        assertEquals(DummyData.contentType,response.getContentType());

        assertEquals(expBodyMAP.get("status"), resMAP.get("status"));
        assertEquals(expBodyMAP.get("message"), resMAP.get("message"));

        assertEquals(((Map)expBodyMAP.get("data")).get("id"),((Map)resMAP.get("data")).get("id"));
        assertEquals(((Map)expBodyMAP.get("data")).get("employee_name"),((Map)resMAP.get("data")).get("employee_name"));
        assertEquals(((Map)expBodyMAP.get("data")).get("employee_salary"),((Map)resMAP.get("data")).get("employee_salary"));
        assertEquals(((Map)expBodyMAP.get("data")).get("employee_age"),((Map)resMAP.get("data")).get("employee_age"));
        assertEquals(((Map)expBodyMAP.get("data")).get("profile_image"),((Map)resMAP.get("data")).get("profile_image"));









    }
    @Test
    public void deneme(){
        specDummy.pathParams("pp1","employee","pp2","3");

    }
}