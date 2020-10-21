package Reusable_Libraries;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_Class_Cross_Browser {
    //declare all the global variables outside of the methods
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void setPrecondition() throws IOException, InterruptedException {
        //set the driver here
        //driver = Reusable_Methods_Loggers.getDriver();
        //set the report path here
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html",true);
    }//end of before suite

    @Parameters("browser")
    //to be able to pick up the name of your test classes dynamically we need to use before method
    @BeforeMethod
    public void captureTestName(String browser, Method methodName) throws IOException, InterruptedException {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = Reusable_Methods_Loggers.getDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            //driver.manage().window().maximize();
        }

        logger = reports.startTest(methodName.getName() + "-" + browser.toUpperCase());
    }//end of before method

    @AfterMethod
    public void endTest()
    {
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void endSession() throws InterruptedException {
        reports.flush();
        Thread.sleep(5000);
        driver.quit();
    }//end of afterSuite





}//end of abstract class
