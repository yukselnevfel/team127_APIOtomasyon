package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C15_baseUrlHerOkuAppQueryParam extends C14_baseUrlHerOkuApp{
        /*

        "https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak
            “firstname” degeri “Susan” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde,
        donen response’un
            status code’unun 200 oldugunu
            ve “Jim” ismine sahip 12 booking oldugunu test edin

         */

    @Test
    public void baseUrlQuery(){
        specHerOkuApp.pathParam("pp1","booking").queryParam("firstname","Jim");

        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");

        //response.prettyPrint();


        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(305));



    }



}

