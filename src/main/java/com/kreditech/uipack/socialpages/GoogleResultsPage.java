package com.kreditech.uipack.socialpages;

import com.kreditech.uipack.pages.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


/**
 * Created by pc on 30.07.2017.
 */
public class GoogleResultsPage {
    /**
     * @param key - company url to find and select needed link in google results.
     * @return new company main page.
     */
    @Step("Click relevant link {key} in google list.")
    public HomePage clickRelevantResultByKey (String key){
        $("a[href*='" + key + "']").click();
        return new HomePage();
    }


}
