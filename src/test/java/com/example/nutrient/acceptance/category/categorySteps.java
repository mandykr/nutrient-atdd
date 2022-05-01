package com.example.nutrient.acceptance.category;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class categorySteps {
    private static final String ENDPOINT = "/api/category";

    @When("카테고리 생성 요청")
    public static ExtractableResponse<Response> 카테고리_생성_요청(String name, String parentId) {
        Map<String, Object> createParams = getCategoryCreateParams(name, parentId);

        return RestAssured.given().log().all()
                .body(createParams)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when().post(ENDPOINT)
                .then().log().all().extract();
    }

    private static Map<String, Object> getCategoryCreateParams(String name, String parentId) {
            Map<String, Object> params = new HashMap<>();
            params.put("name", name);
            params.put("parentId", parentId);

            return params;
    }

    @Then("카테고리 생성됨")
    public void 카테고리_생성됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("카테고리 수정 요청")
    public void 카테고리_수정_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("카테고리 수정됨")
    public void 카테고리_수정됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("카테고리 삭제 요청")
    public void 카테고리_삭제_요청() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("카테고리 삭제됨")
    public void 카테고리_삭제됨() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}