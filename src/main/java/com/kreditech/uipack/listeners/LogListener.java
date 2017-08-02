package com.kreditech.uipack.listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.reporters.ExitCodeListener;

/**
 * Created by pc on 31.07.2017.
 */
public class LogListener extends ExitCodeListener {

    protected CustomReport report = new CustomReport();

    public void onStart(ITestContext context) {
        this.report.start();
    }

    public void onTestFailure(ITestResult result) {
        this.report.finish(result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        this.report.finish(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        this.report.finish(result.getName());
    }

}
