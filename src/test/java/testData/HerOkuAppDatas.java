package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppDatas {
      /*
    {
              "firstname" : "Ahmet",
              "lastname" : “Bulut",
              "totalprice" : 500,
              "depositpaid" : false,
              "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                      },
              "additionalneeds" : "wi-fi"
              }
     */

    public static JSONObject JsonReqBodOlustur(){

        JSONObject innerData=new JSONObject();
        innerData.put( "checkin" , "2021-06-01");
        innerData.put( "checkout" , "2021-06-10");

        JSONObject reqData=new JSONObject();
        reqData.put("firstname","Ahmet");
        reqData.put("lastname","Bulut");
        reqData.put("totalprice",500);
        reqData.put("depositpaid",false);
        reqData.put("bookingdates",innerData);
        reqData.put("additionalneeds","wi-fi");

        return reqData;

    }

    public static JSONObject JsonexpBodyOlustur(){

        JSONObject expData=new JSONObject();
        JSONObject booking=JsonReqBodOlustur();

        expData.put("bookingid",24);
        expData.put("booking",booking);

        return  expData;


    }
/*
     {
                        "firstname" : "Ahmet",
                        "lastname" : "Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
 */
 public static Map<String,Object>reqBodyOlustur(){


     Map<String ,Object> bookingdatesBodyMap=new HashMap<>();
     bookingdatesBodyMap.put("checkin" , "2021-06-01");
     bookingdatesBodyMap.put("checkout" , "2021-06-10");

     Map<String ,Object> reqBodyMap=new HashMap<>();
     reqBodyMap.put("firstname" , "Ahmet");
     reqBodyMap.put("lastname" , "Bulut");
     reqBodyMap.put("totalprice" , 500);
     reqBodyMap.put("depositpaid" , false);
     reqBodyMap.put("bookingdates",bookingdatesBodyMap);
     reqBodyMap.put("additionalneeds" , "wi-fi");


     return reqBodyMap;
 }


}
