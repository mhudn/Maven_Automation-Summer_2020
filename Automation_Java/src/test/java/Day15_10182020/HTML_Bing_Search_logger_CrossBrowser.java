package Day15_10182020;

import Reusable_Libraries.Abstract_Class_Cross_Browser;
import Reusable_Libraries.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HTML_Bing_Search_logger_CrossBrowser extends Abstract_Class_Cross_Browser
{
    @Test
    public void Bing_Search() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to Bing home page");
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='q']","Cars",logger,"Search Field");
        Reusable_Methods_Loggers.submit(driver,"//*[@id='sb_form_go']",logger,"Search Button");
        Thread.sleep(2500);
        String result = Reusable_Methods_Loggers.captureText(driver,"//*[@class='sb_count']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[0]);
        //after all the test steps per @Test you must end the test as well
        driver.quit();
    }//end of test

}
