package com.fachri.helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class Utility {


    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/com/fachri/helper/JSONSchemaData/" + JSONFile);
    }

    public static String generateRandomEmail() {
        String email;
        String temp = RandomStringUtils.randomAlphanumeric(7);
        email = temp + "@test-qa.com";
        return email;
    }

}


