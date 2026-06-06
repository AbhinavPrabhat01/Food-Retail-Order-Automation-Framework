package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.DriverFactory;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;

import java.io.File;

public class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;

    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpReport(){
        extent = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void setUp(java.lang.reflect.Method method){

        log.info("🚀 Test setup started");

        driver = DriverFactory.initDriver();

        // ✅ Create test entry in report
        test = extent.createTest(method.getName());

        log.info("✅ Test setup completed");
    }

    @AfterMethod
    public void tearDown(ITestResult result){

        log.info("🧹 Test teardown started");

        String testName = result.getName();

        if(result.getStatus() == ITestResult.FAILURE){

            log.error("❌ Test failed: {}", testName);
            test.fail("Test Failed");

            if(driver != null){
                String path = ScreenshotUtils.captureScreenshot(driver, testName);
                String imageName = new File(path).getName();
                test.addScreenCaptureFromPath(imageName);
                log.error("📸 Screenshot saved at: {}", path);
            }

        } else if(result.getStatus() == ITestResult.SUCCESS){

            log.info("✅ Test passed: {}", testName);
            test.pass("Test Passed");

        } else {

            log.warn("⚠️ Test skipped: {}", testName);
            test.skip("Test Skipped");
        }

        if(driver != null){
            //driver.quit();
            log.info("🛑 Browser closed");
        }

        log.info("✅ Test teardown completed");
    }

    @AfterSuite
    public void tearDownReport(){
        extent.flush(); // ✅ Write report
    }
}