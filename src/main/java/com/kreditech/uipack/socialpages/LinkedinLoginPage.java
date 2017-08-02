package com.kreditech.uipack.socialpages;

import com.kreditech.uipack.domain.User;
import com.kreditech.uipack.helpers.Assertions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

/**
 * Created by pc on 30.07.2017.
 */
public class LinkedinLoginPage {

    @Step("Open Linkedin login page.")
    public LinkedinLoginPage openPage(){
        open("https://www.linkedin.com/");
        Assertions.assertEquals(title(), "LinkedIn: Log In or Sign Up", "Page title");
        return this;
    }

    @Step("Login as {user.userName} / {user.userPass}.")
    public void loginAs (User user){
        $("#login-email").val(user.getUserName());
        $("#login-password").val(user.getUserPass());
        $("#login-submit").click();
    }
}
