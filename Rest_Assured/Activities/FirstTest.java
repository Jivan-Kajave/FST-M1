package examples;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class FirstTest {
    // GET https://petstore.swagger.io/v2/pet/findByStatus?status=alive
    @Test
    public void getRequestWithQueryParam(){
        //Create a baseURI
        Response response=
                given(). //Request specifications
                    baseUri("https://petstore.swagger.io/v2/pet").
                        header("Content-Type", "application/json").
                        queryParam("status", "alive").
                        log().all().

                when().
                    get("/findByStatus");

        //Print Response Headers
        System.out.println(response.getHeaders());

        //Print Response Body
        System.out.println(response.getBody().asString());
        //System.out.println(response.getBody().asPrettyString());
        //Extract Individual Properties
        String petStatus = response.then().extract().path("[0]['status']");
        System.out.println("pet status is :" + petStatus);
        Assert.assertEquals(petStatus, "alive");
    }

    // GET https://petstore.swagger.io/v2/pet/{petId}
    @Test
    public void getRequestWithPathParam() {
        given().//Request Specifications
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                pathParam("petId", 1002).
                log().all().

        when().
                get("/{petId}").
        then(). //Response Specifications
            statusCode(200).
            body("name",equalTo("Mufasa")).
            body("status",equalTo("alive")).
            log().all();

    }
}
