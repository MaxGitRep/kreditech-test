package com.kreditech.uitest;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters({ "browser" })
    @BeforeClass(description = "Configure browser before test")
    public void setUp(@Optional("chrome") String browser){
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            Configuration.browser = "marionette";
        } else {
            ChromeDriverManager.getInstance().setup();
            Configuration.browser = browser;
        }
        Configuration.baseUrl = "https://www.kreditech.com/";
        //Configuration.holdBrowserOpen = true;
    }
}
