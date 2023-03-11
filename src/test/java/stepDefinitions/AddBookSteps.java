package stepDefinitions;

import api.util.JsonTree;
import api.util.RestAssuredFunctions;
import api.util.getBookResponse;
import files.util.Globals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import payloadJava.bookStore.GetBooksRequest;
import payloadJava.bookStore.GetBooksResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;

public class AddBookSteps {
    @Given("the user is able to add book successfully")
    public void theUserIsAbleToAddBookSuccessfully() {
        RestAssuredFunctions restAssuredFunctions = new RestAssuredFunctions();
        Response response = restAssuredFunctions.getResponse("http://216.10.245.166/Library/Addbook.php", null, returnHeaderParameters(),
                null, null, returnAddBookBody(), Method.POST);
        ResponseBody responseBody = response.getBody();
        if (response.statusCode() == 404) {
            GetBooksResponse getBooksResponse = responseBody.as(GetBooksResponse.class);
            String msg = getBooksResponse.getMsg();
            System.out.println(msg);
        }
        System.out.println(response.getBody().asString());
    }

    public Map<String, String> returnHeaderParameters() {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        return headerMap;
    }

    public GetBooksRequest returnAddBookBody() {
        GetBooksRequest getBooksRequest = new GetBooksRequest();
        getBooksRequest.setName("Learn Appium Automation with Java");
        getBooksRequest.setIsbn("bczd");
        getBooksRequest.setAisle("227");
        getBooksRequest.setAuthor("John Foe");
        return getBooksRequest;
    }

    @Then("the user is able to convert json to maps")
    public void theUserIsAbleToConvertJsonToMaps() throws IOException {
        JsonTree jsonTree = new JsonTree();
        jsonTree.convertJsonToMaps(Globals.PROJECT_PATH + "\\src\\main\\java\\payload\\AddBook.json");
    }

    @Then("the user is able to retrieve value from json")
    public void theUserIsAbleToRetrieveValueFromJson() throws FileNotFoundException {

    }

    @Given("the user is able to get book successfully")
    public void theUserIsAbleToGetBookSuccessfully() {
        RestAssured.baseURI = "http://216.10.245.166";
//        given().param("ID", "bczd227").get("/Library/GetBook.php").then().assertThat().statusCode(200).assertThat()
//                .body("author",equalTo(new String[]{"John Foe"}));
        Response response = given().param("ID", "bczd227").get("/Library/GetBook.php").then().extract().response();
        String responseText = response.getBody().asString();
        JsonPath jsonPath = response.jsonPath();
        List<GetBooksResponse> books = jsonPath.getList("", GetBooksResponse.class);
        System.out.println(books.get(0).getBook_name());
    }

}
