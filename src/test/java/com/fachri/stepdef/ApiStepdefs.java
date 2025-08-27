package com.fachri.stepdef;

import com.fachri.page.ApiPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepdefs {

    ApiPage apiPage;

    public ApiStepdefs() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
       apiPage.prepareUrlFor(url);
    }

    @When("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @And("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @And("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiPostCreateNewUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUsers() {
        apiPage.validationResponseBodyPostCreateNewUsers();
    }

    @And("hit api update data")
    public void hitApiUpdateData() {
        apiPage.hitApiUpdateData();
    }

    @And("validation response body update user")
    public void validationResponseBodyUpdateUsers() {
        apiPage.validationResponseBodyUpdateUsers();
    }

    @And("hit api delete new user")
    public void hitApiDeleteNewUser() {
        apiPage.hitApiDeleteNewUser();
    }

}
