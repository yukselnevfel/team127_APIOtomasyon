package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_baseUrlJsonPlaceDelete extends BaseUrlJsonPlaceUrl {
    /*
            // https://jsonplaceholder.typicode.com/posts/50 endpointine
            //   bir DELETE request gonderdigimizde donen response’un
            //   status code’unun 200 oldugunu
            //   ve response body’sinin null oldugunu test edin
     */

    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","60");

        Response response=given()
                                .when().spec(specJsonPlaceHolder)
                                .delete("{/pp1]/{pp2}");


        response.then().assertThat().statusCode(200).body("title", Matchers.nullValue());
    }

    @Test
    public void testDeneme(){
        // end point ve request body boluştur.
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",55);
        Response response= given().spec(specJsonPlaceHolder).when().delete("/{pp1}/{pp2}");

        response.then().assertThat()
                .statusCode(200)
                .body("title",Matchers.nullValue());

    }
}

