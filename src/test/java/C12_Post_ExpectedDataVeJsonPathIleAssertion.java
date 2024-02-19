import org.json.JSONObject;
import org.testng.annotations.Test;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    /*
https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un id haric asagidaki gibi oldugunu test edin.

Request body
{
"firstname" : "Hasan",
"lastname" : "Yagmur",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
    "checkin" : "2021-06-01",
    "checkout" : "2021-06-10"
    },
"additionalneeds" : "wi-fi"
}

Expected Response Body
{
"bookingid":24,
"booking":{
    "firstname":"Hasan",
    "lastname":"Yagmur",
    "totalprice":500,
    "depositpaid":false,
    "bookingdates":{
        "checkin":"2021-06-01",
        "checkout":"2021-06-10"
        },
"additionalneeds":"wi-fi"
}
}
 */
    @Test
    public void expBodyPostTesti(){
        String url ="https://restful-booker.herokuapp.com/booking";
        JSONObject innerData=new JSONObject();
        innerData.put( "checkin","2021-06-01");
        innerData.put( "checkout",
                "2021-06-10");
    }
}
