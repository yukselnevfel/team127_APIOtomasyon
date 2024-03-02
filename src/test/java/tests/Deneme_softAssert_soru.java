package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Deneme_softAssert_soru {
    /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
   "name": “Ahmet",
   "salary": "1230",
   "age": "44",
   "id": 40
}
}
Response Body
{ "status": "success",
  "data": {
    "status": "success",
    "data": {
     "name": “Ahmet",
     "salary": "1230",
     "age": "44",
     "id": 40 }
},
  "message": "Successfully! Record has been updated."
     */
    @Test
    public void softAssertTesti(){
        String url=" http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject dataBilgileriJson=new JSONObject();
        dataBilgileriJson.put("name" ,"Ahmet");
        dataBilgileriJson.put("salary", "1230");
        dataBilgileriJson.put("age", "44");
        dataBilgileriJson.put("id", 40);

        JSONObject reqBody=new JSONObject();
        reqBody.put("status", "success");
        reqBody.put("data", dataBilgileriJson);

        JSONObject expData=new JSONObject();
        expData.put("status", "success");
        expData.put("data", reqBody);
        expData.put("message", "Successfully! Record has been updated.");

        //System.out.println(expData.toString());

        //Request gönder ve response 'ı kaydet
        Response response =given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
        JsonPath responseJsonPath=response.jsonPath();
        //SoftAssert islemi
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJsonPath.get("status"),expData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.status"),expData.getJSONObject("data").get("status"));
        softAssert.assertEquals(responseJsonPath.get("data.data.name"),expData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.data.id"),expData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),expData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJsonPath.get("data.data.age"),expData.getJSONObject("data").getJSONObject("data").get("age"));

        softAssert.assertAll();
    }
}
