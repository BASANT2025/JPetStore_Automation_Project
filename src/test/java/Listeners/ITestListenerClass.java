package Listeners;

import Utilities.U04_Logs;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener {

    public void onTestStart(ITestResult result) {
        U04_Logs.info("Test Case " + result.getName() + " started");
    }

    public void onTestSuccess(ITestResult result) {
        U04_Logs.info("Test Case " + result.getName() + " passed");
    }

    public void onTestSkipped(ITestResult result) {
        U04_Logs.info("Test Case " + result.getName() + " skipped");
    }
}
