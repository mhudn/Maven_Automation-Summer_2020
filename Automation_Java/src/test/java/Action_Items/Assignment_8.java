package Action_Items;

import Reusable_Libraries.Abstract_Class_Cross_Browser;
import Reusable_Libraries.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class Assignment_8 extends Abstract_Class_Cross_Browser
{
    @Test
    public void fedexDotCom() throws InterruptedException, AWTException {
        logger.log(LogStatus.INFO,"Navigating to fedex home page");
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        Reusable_Methods_Loggers.click(driver,"//*[@data-analytics='hdr|tab|3|design & print']", logger,"Design & Print");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@href='https://www.fedex.com/apps/printonline/#!']", logger,"Upload a Print-Ready File");
        Thread.sleep(4000);
        Reusable_Methods_Loggers.checkTitle(driver,"https://www.fedex.com/apps/printonline/#!", logger,"Fedex Office Print");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@title='Document Printing']", logger,"Document Printing");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@title='Get Started - Copies & Custom Projects']", logger,"Copies & Custom Projects");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@name='upload-files-button']", logger,"USE YOUR FILE and Uploading a picture");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.uploadFile("C:\\Users\\Mohi8\\Desktop\\QA_Art.jpg");
        Thread.sleep(5000);
        Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='item-quantity']","5",logger," in Quantity");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[contains(@name,'update_quanity-addToCart')]",logger,"ADD TO CART");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@id='cartToCheckoutBtn']",logger,"CHECKOUT");
        Thread.sleep(2000);
        Reusable_Methods_Loggers.click(driver,"//*[@id='continueAsGuest']",logger,"PROCEED AS GUEST");
        Thread.sleep(3000);
        Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='radiusSelect']","5 Miles",logger," Pick up range");
        Thread.sleep(3000);
        Reusable_Methods_Loggers.typeAndSubmit(driver,"//*[@id='loc_seacrh_text']","11230",logger," zipCode");
        Thread.sleep(2000);
        /*String msg1 =*/
        Reusable_Methods_Loggers.captureText(driver,"//*[@id='5732']",logger,"Location Name and Distance");
        Thread.sleep(2000);
        /*String msg2 =*/
        Reusable_Methods_Loggers.captureText(driver,"//*[@class='details']",logger,"Location Address, Phone Number and Time");
        Thread.sleep(2000);
        //logger.log(LogStatus.INFO,msg1 + msg2);

    }

}
