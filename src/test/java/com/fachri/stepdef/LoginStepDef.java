package com.fachri.stepdef;

import com.fachri.BaseTest;
import com.fachri.page.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDef extends BaseTest {

    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("user input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        loginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("user see error messege {string}")
    public void userSeeErrorMessege(String errorMessage) {
        loginPage.validateErrorAppear("Epic sadface: Username and password do not match any user in this service");
    }
}
