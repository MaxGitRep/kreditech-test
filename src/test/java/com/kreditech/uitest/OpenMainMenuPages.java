package com.kreditech.uitest;

import com.kreditech.uipack.pages.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

/**
 * Created by pc on 30.07.2017.
 */
public class OpenMainMenuPages extends BaseTest {

    @Test
    @Description("Test can open pages from Main Menu")
    public void testCanOpenPagesFromMenu() {
        new HomePage()
                .openPage()
                .openPageByMenuItem("What we do",
                        "Kreditech – Providing access to credit for the underbanked",
                        "https://www.kreditech.com/what-we-do/")
                .openPageByMenuItem("Careers",
                        "Kreditech Career Opportunities – Hamburg and worldwide",
                        "https://www.kreditech.com/careers/")
                .openPageByMenuItem("Press",
                        "Media & Press | Kreditech Group Websitet",
                        "https://www.kreditech.com/press/");
    }
}
