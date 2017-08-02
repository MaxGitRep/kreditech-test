package com.kreditech.uipack.socialpages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by pc on 30.07.2017.
 */
public class GooglePage {

    /**
     * @param key - keyword or fraze for searching in google.com.
     * after type key pressed 'Enter' button
     */
    @Step("Search in google by key {key}.")
    public GoogleResultsPage searchByKey(String key){
        open("https://www.google.com/");
        $(By.name("btnK")).should(exist);
        $(By.name("q")).setValue(key).pressEnter();
        return new GoogleResultsPage();
    }
}
