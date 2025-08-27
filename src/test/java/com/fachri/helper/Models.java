package com.fachri.helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static com.fachri.helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;
    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 96f78e4e92590df8b7cd7dada69f8cff0e8ec62d67022dec77fe9d6f337cfdd7");
    }

    public static Response getSpecificUser(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateUser(String endpoint) {
        String name = "Fachri QA";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name",name);
        payload.put("gender",gender);
        payload.put("email",email);
        payload.put("status",status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);

    }
    public static Response updateUser(String endpoint, String userId) {
        setupHeaders();

        String name = "Fachri Edit";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name",name);
        payload.put("gender",gender);
        payload.put("email",email);
        payload.put("status",status);

        String hasildata = endpoint + "/" + userId;
        return request.body(payload.toString()).when().put(hasildata);
    }

    public static Response deleteUser(String endpoint, String userId) {
        setupHeaders();
        String hasildelete = endpoint + "/" + userId;
        //System.out.println(finalEndpoint);
        return request.when().delete(hasildelete);
    }
    public static Response getListTag(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }

}