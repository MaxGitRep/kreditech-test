package com.kreditech.uitest;

import com.kreditech.uipack.domain.User;
import com.kreditech.uipack.pages.HomePage;
import com.kreditech.uipack.socialpages.LinkedinLoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


/**
 * Created by pc on 30.07.2017.
 */
public class OpenSocialLinks extends BaseTest {

    @Test
    @Description("Test can open social links to see company profiles")
    public void testCanOpenSocialCompanyProfiles() {
        User user = new User("raj.bigtheory@gmail.com", "Dza94t2017");
        new LinkedinLoginPage()
                .openPage()
                .loginAs(user);

        new HomePage()
                .openPage()
                .openSocialLink("linkedin", "Kreditech Holding SSL GmbH: Overview | LinkedIn")
                .openSocialLink("facebook", "Kreditech - Home | Facebook")
                .openSocialLink("twitter", "Kreditech (@Kreditech) | Twitter");
    }
}
