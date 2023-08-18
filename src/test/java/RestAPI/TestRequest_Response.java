package RestAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRequest_Response {

    String BaseURL = "https://reqres.in";
    RequestSpecification reqSpec;
    LibReqRsData lib;

    @BeforeClass
    public void before() {
        lib = new LibReqRsData();
        RestAssured.baseURI = BaseURL;
        reqSpec = RestAssured
                .given()
                .header("Content-Type", "application/json");

    }

    @Test(dataProvider = "dp")
    public void TestLogin(String strName, String strRole) {

        lib.setStrName(strName);
        lib.setStrRole(strRole);
        JSONObject user = lib.DataJsonCreateUser();
        System.out.println(user.toString());

        Response resp = reqSpec
                .body(user.toString())
                .when()
                .post("/api/users");
        Assert.assertEquals(resp.getStatusCode(), 201);
        JsonPath jsonPath = resp.jsonPath();

        Assert.assertEquals(jsonPath.getString("name"), strName);
        Assert.assertEquals(jsonPath.getString("job"), strRole);
    }

    @DataProvider
    public String[][] dp() {
        return new String[][]{
                new String[]{"Asim", "IM"},
                new String[]{"Bassra", "DM"},
        };
    }

}
