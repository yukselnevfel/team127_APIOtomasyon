import org.testng.annotations.Test;

public class C6_Post_ResponseBodyTesti {
    /*
https://jsonplaceholder.typicode.com/posts url'ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response'un,
        status code'unun 201,
        ve content type'inin application/json
        ve Response Body'sindeki,
         "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini test edin.
 */
@Test
    public void postResponseBodyTesti(){
    String url="https://jsonplaceholder.typicode.com/posts";
}
}
