package com.fachri.page;


import com.fachri.helper.Endpoint;
import com.fachri.helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static com.fachri.helper.Models.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setURL, global_user_id = null;
    private static Response res;

    public void prepareUrlFor(String url) {
        switch (url) {
            case "get_list_users":
                setURL = Endpoint.get_list_users;
                break;
            case "create_new_user":
                setURL = Endpoint.create_new_user;
                break;
            case "modif_user":
                setURL = Endpoint.modif_user;
                break;
            default:
                System.out.println("input right url");
        }
    }

    public void hitApiGetListUsers() {
        res = getSpecificUser(setURL);
    }

    public void validationStatusCodeIsEquals(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.getFirst()).isNotNull();
        assertThat(name.getFirst()).isNotNull();
        assertThat(email.getFirst()).isNotNull();
        assertThat(gender.getFirst()).isIn("female", "male");
        assertThat(status.getFirst()).isIn("active", "inactive");
    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiPostCreateNewUser() {
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyPostCreateNewUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_user_id = Integer.toString(id);
    }

    public void hitApiUpdateData() {
        res = updateUser(setURL, global_user_id);
        System.out.println(res.getBody().asString());
    }

    public void validationResponseBodyUpdateUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

    }

    public void hitApiDeleteNewUser() {
        res = deleteUser(setURL, global_user_id);
        System.out.println(res.getBody().asString());
    }

}
