package api.sampleDev;

import com.example.automation.pojo.ResponseReqRes;
import com.example.automation.pojo.Users;
import com.example.automation.utils.commonUtils.APIUtils;
import com.example.automation.utils.commonUtils.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestReqres {
    APIUtils apiUtils = new APIUtils();

    @Test(priority = 1)
    public void TestPostRequest() throws JsonProcessingException {
        Users users = new Users();
        users.setJob("developer");
        users.setName("rk");

        String bodyStr = JSONUtils.pojoToJson(users);

        Response postResponse = RestAssured.given().header("x-api-key", "reqres-free-v1").
                contentType(ContentType.JSON).body(bodyStr).when().post("https://reqres.in/api/users?page=2").then().extract().response();
        assert postResponse.getStatusCode() == 201;

        System.out.println(postResponse.asString());
    }

    //@Test(priority = 2)
    public void TestGetRequest() throws JsonProcessingException {
        Response getResponse = RestAssured.given().header("x-api-key", "reqres-free-v1").
                when().get("https://reqres.in/api/users?page=2").then().extract().response();
        System.out.println(getResponse.asString());
        ResponseReqRes responseReqRes = JSONUtils.jsonToPojo(getResponse.asString());

        System.out.println(responseReqRes.getTotal());
    }
}
