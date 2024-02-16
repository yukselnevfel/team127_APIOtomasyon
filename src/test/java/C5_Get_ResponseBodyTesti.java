import org.testng.annotations.Test;

public class C5_Get_ResponseBodyTesti {

    //   https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
    //   donen Response'in
    //   status code'unun 200,
    //   ve content type'inin application/json; charset=utf-8,
    //   ve response body'sinde bulunan userId'nin 5,
    //   ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.

    @Test
    public void responseBodyTesti(){
        //1-Endpoint belirlenerek hazırlanır
        String url="https://jsonplaceholder.typicode.com/posts/44";
        //        2-Gerekli ise Expected Data hazırlanır
        //        3-Actual Data kaydedilir
        //        4-Assertion İşlemi Yapılır

    }
}
