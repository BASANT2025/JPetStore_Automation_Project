package Listeners;

import Utilities.U01_BaseClass;
import Utilities.U04_Logs;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static Utilities.U02_DriverManager.getDriver;

public class IInvokedListenerClass implements IInvokedMethodListener {
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            U04_Logs.info("Test Case " + testResult.getName() + " failed");
            U01_BaseClass.takeScreenshot(getDriver(), testResult.getName());
        }
    }

    }
