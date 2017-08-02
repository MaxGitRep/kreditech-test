package com.kreditech.uipack.listeners;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by pc on 31.07.2017.
 */
public class AllureScreenshotListener extends ExitCodeListener {

    public void onTestSuccess(ITestResult iTestResult) {
        attachScreenshot();
    }

    public void onTestFailure(ITestResult iTestResult) {
        onTestSuccess(iTestResult);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot(){
        return ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
