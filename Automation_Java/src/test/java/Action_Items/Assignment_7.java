package Action_Items;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Assignment_7 extends Abstract_Class
    //Abstract_Class sets the chrome driver and HTML Report
{
    //declare all the global variables outside

    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @Test
    public void ExpressDotCom() throws InterruptedException, WriteException, IOException, BiffException
    {

        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_Checkout_Info.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_Checkout_Info_Results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

        //System.out.println(rowCount);

        Reusable_Methods_Loggers.checkTitle(driver, "https://www.express.com", "Men's and Women's Clothing");

        for (int i = 1; i < rowCount; i++)
        {
            //reading through excel sheet
            //I need to get the content of the cells as String
            //column is hard coded and row is dynamic(i)
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String cardNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String CVV = writableSheet.getCell(13, i).getContents();


            driver.manage().deleteAllCookies();
            logger.log(LogStatus.INFO,"Navigating to Express.com");
            driver.navigate().to("https://www.express.com/");
            Thread.sleep(2000);
            System.out.println("\n__________________________________________________________");

            Reusable_Methods_Loggers.mouseHover(driver,"//*[@href='/mens-clothing']",logger," on MEN section");
            Thread.sleep(1000);

            Reusable_Methods_Loggers.mouseClick(driver,"//*[@href='/mens-clothing/shirts/cat410008']",logger," on Shirts option");
            Thread.sleep(2000);

            Reusable_Methods_Loggers.clickByIndex(driver,"//*[@class='_3TJgM']",2,logger,"on third shirt image");
            Thread.sleep(2000);

            Reusable_Methods_Loggers.click(driver,"//*[@value='"+size+"']",logger,size + " Size");
            Thread.sleep(2000);

            Reusable_Methods_Loggers.click(driver,"//*[contains(text(),'Add to Bag')]", logger, "Add to Bag button");
            Thread.sleep(2000);

            Reusable_Methods_Loggers.mouseHover(driver,"//div[3]/div[1]/button[1]", logger,"Shopping bag icon");
            Thread.sleep(1000);
            Reusable_Methods_Loggers.mouseClick(driver,"//*[contains(text(),'View Bag & Check Out')]", logger,"View Bag button");
            Thread.sleep(2000);

            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@id='qdd-0-quantity']", quantity, logger," Quantity");
            Thread.sleep(1000);

            Reusable_Methods_Loggers.click(driver,"//*[@id='continue-to-checkout']",logger, "CHECKOUT");
            Thread.sleep(1000);
            Reusable_Methods_Loggers.click(driver,"//*[@class='_1UFak _2YpK4 _1f9t- _2yrqS']",logger,"CHECKOUT AS GUEST");
            Thread.sleep(1000);

            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='firstname']",firstName,logger," First Name");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='lastname']",lastName,logger," Last Name");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='email']",email,logger," Email");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='confirmEmail']",email,logger," Confirm Email");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='phone']",phoneNumber,logger," Phone Number");
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"Continue");
            Thread.sleep(1000);

            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.line1']",address,logger," Address");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.postalCode']",zipCode,logger," Postal Code");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='shipping.city']",city,logger," City");
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='shipping.state']",state,logger," State");
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"Continue");
            Thread.sleep(4000);
            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"Continue");
            Thread.sleep(2000);
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@id='creditCardNumberInput']",cardNumber,logger," Credit Card Number");
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='expMonth']",expMonth,logger," Exp Month");
            Reusable_Methods_Loggers.dropDownMenu(driver,"//*[@name='expYear']",expYear,logger," Exp Year");
            Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='cvv']",CVV,logger," CVV");

            Reusable_Methods_Loggers.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']",logger,"Continue");

            Thread.sleep(2000);

            String result = Reusable_Methods_Loggers.captureText(driver,"//*[@id='rvn-note-NaN']",logger," Error Message");

            Thread.sleep(2000);

            Label label = new Label(14,i,result);
            writableSheet.addCell(label);

        }

        Thread.sleep(5000);
        writableFile.write();
        writableFile.close();
        driver.quit();
    }
}
