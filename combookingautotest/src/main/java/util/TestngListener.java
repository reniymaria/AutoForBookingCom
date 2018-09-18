package util;

import org.testng.*;
import test.BaseTest;

public class TestngListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    public void onStart(ISuite iSuite) {

    }

    public void onFinish(ISuite iSuite) {

    }

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

        handleFailure(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    private void handleFailure(ITestResult result) {
        if (BaseTest.getDriver() != null) {
            String caseName = getCaseName(result);
            Photographer.doScreenshot(caseName);
        }
    }

    private String getCaseName(ITestResult result) {
        return result.getTestClass().getRealClass().getSimpleName() + "."  + result.getMethod().getMethodName();
    }
}
