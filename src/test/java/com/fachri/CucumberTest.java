package com.fachri;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.fachri"},
        features = {"src/test/resources"},
        plugin = {"pretty","html:reports/cucumber.html", "json:reports/cucumber.json"} //{"pretty"} // menampilkan test per log
)
public class CucumberTest {
}
