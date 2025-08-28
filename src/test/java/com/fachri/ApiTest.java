package com.fachri;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.fachri"},
        features = {"src/test/resources/api.feature"},
        plugin = {"pretty","html:reports/api/api-report.html", "json:reports/api/api-report.json"} //{"pretty"} // menampilkan test per log
)
public class ApiTest {
}
