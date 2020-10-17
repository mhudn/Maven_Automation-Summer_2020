package Action_Items;

import Reusable_Libraries.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Assignment_6
{
    //declare all the global variables outside
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;
    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //setting the chrome driver
        driver = Reusable_Methods.getDriver();
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/KayakDotCom_Info.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/KayakDotCom_Results.xls"),readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();

        //System.out.println(rowCount);
    }

    @Test
    public void KayakDotCom() throws InterruptedException, WriteException {

        Reusable_Methods.checkTitle(driver,"https://www.kayak.com", "KAYAK");

        for(int i = 1; i < rowCount; i++)
        {
            driver.navigate().to("https://www.kayak.com/");

            //reading through excel sheet
            //I need to get the content of the cells as String
            //column is hard coded and row is dynamic(i)
            String Airport = writableSheet.getCell(0, i).getContents();
            String StartDate = writableSheet.getCell(1, i).getContents();
            String StartTime = writableSheet.getCell(2, i).getContents();
            String EndDate = writableSheet.getCell(3, i).getContents();
            String EndTime = writableSheet.getCell(4, i).getContents();
            String VehicleSize = writableSheet.getCell(5, i).getContents();

            System.out.println("\n__________________________________________________________");


            Reusable_Methods.click(driver,"//*[contains(@id,'pickup-display')]"," on Enter an airport or city");
            Reusable_Methods.sendKeys(driver,"//*[@name='pickup']",Airport," on 'Enter an airport or city' box");
            //Reusable_Methods.click(driver,"//*[@class='item-info']"," on first drop down suggestions");
            Thread.sleep(100);

            //startDate
            Reusable_Methods.click(driver,"//*[@aria-label='Pick-up date']","Start Date");
            Thread.sleep(1000);
            Reusable_Methods.typeAndSubmit(driver, "//*[contains(@id,'pickup-date-input')]", StartDate, " as Start Date");
            Thread.sleep(1000);

            Reusable_Methods.click(driver,"//*[@class='title dark']","Outside the boxes");
            Thread.sleep(1000);

            //endDate
            Reusable_Methods.click(driver,"//*[@aria-label='Drop-off date']","End Date");
            Thread.sleep(1000);
            Reusable_Methods.typeAndSubmit(driver, "//*[contains(@id,'dropoff-date-input')]", EndDate, " as End Date");
            Thread.sleep(1000);

            Reusable_Methods.click(driver,"//*[@class='title dark']","Outside the boxes");
            Thread.sleep(1000);


            Reusable_Methods.mouseClick(driver, "//*[contains(@id,'start-time-select-display')]","Start Time box");
            Thread.sleep(1000);
            //now click on start time value
            Reusable_Methods.mouseClick(driver, "//*[contains(@id,'start-time-select-option') and @data-title='"+StartTime+"']", StartTime +" from drop down");
            Thread.sleep(100);

            Reusable_Methods.click(driver,"//*[@class='title dark']","Outside the boxes");
            Thread.sleep(1000);


            Reusable_Methods.mouseClick(driver, "//*[contains(@id,'end-time-select-display')]","End Time box");
            Thread.sleep(1000);
            //now click on start time value
            Reusable_Methods.mouseClick(driver, "//*[contains(@id,'end-time-select-option') and @data-title='"+EndTime+"']", EndTime +" from drop down");
            Thread.sleep(1000);

            Reusable_Methods.click(driver,"//*[@type='submit']"," on Search button");
            Thread.sleep(2500);


            Reusable_Methods.mouseClick(driver,"//*[contains(text(),'"+VehicleSize+"')]","vehicle size");
            Thread.sleep(5000);

            Reusable_Methods.clickByIndex(driver,"//*[contains(text(),'View Deal')]", 3,"View Deal");
            //index 3 to ignore the sponsored one
            Thread.sleep(3000);


            Reusable_Methods.switchTab(driver,1);

            /*
            Codes for capturing price would go here if search result was not so dynamic! S I G H .  .  .  .
            */

            String result = null;


            Label label = new Label(6,i,result);
            writableSheet.addCell(label);

            Reusable_Methods.switchTab(driver,0);
            driver.manage().deleteAllCookies();
            Thread.sleep(5000);

        }

    }


    @AfterSuite
    public void closingInfo() throws IOException, WriteException
    {
        writableFile.write();
        writableFile.close();
        //driver.quit();
    }
}
