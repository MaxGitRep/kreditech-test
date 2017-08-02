package com.kreditech.uipack.pages;

import com.kreditech.uipack.helpers.Assertions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;


/**
 * Created by pc on 30.07.2017.
 */
public class HomePage {

    @Step("Open home page and check title.")
    public HomePage openPage(){
        open("/");
        String titlePage = "Kreditech - Financial Freedom for the Underbanked";
        Assertions.assertEquals(title(), titlePage, "Page title");
        $("#footer").should(exist);
        return this;
    }

    @Step("Open {socialPage} page and check correct title {titlePage}.")
    public HomePage openSocialLink(String socialPage, String titlePage) {
        $("div.social." + socialPage).click();
        switchTo().window(1);
        Assertions.assertEquals(title(), titlePage, "Page title");
        switchTo().window(1).close();
        switchTo().window(0);
        return new HomePage();
    }

    @Step("Open page {itemName} from main Menu and check page title, page url.")
    public HomePage openPageByMenuItem(String itemName, String titlePage, String urlPage) {
        $("#menu-main").findElementByLinkText(itemName).click();
        Assertions.assertEquals(title(), titlePage, "Page title");
        Assertions.assertEquals(switchTo().window(0).getCurrentUrl(), urlPage, "Page url");
        return new HomePage();
    }
}
