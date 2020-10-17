package Day10_10032020;

import Reusable_Libraries.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Data_Driven_Mortgage
{
    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        //setting up the chrome driver
        WebDriver driver = Reusable_Methods.getDriver();

        //Step 1: locate the readable excel workbook
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Mortgage_Info.xls"));

        //Step 2: locate the excel sheet for this readable workbook
        //Sheet readableSheet = readableFile.getSheet(0);

        //Step 3: make a copy of readable file to write back to the excel so that it doesn't corrupt the original
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Mortgage_Info_Result.xls"), readableFile);

        //Step 4: define the writable sheet for writable file
        WritableSheet writableSheet = writableFile.getSheet(0);

        //get the count of the rows that are not empty
        int rowCount = writableSheet.getRows();


        for(int i = 1; i < rowCount; i++)
        {
            driver.navigate().to("https://www.mortgageCalculator.org");
            Thread.sleep(2000);

            //I need to get the content of the cell
            //column is hard coded row is dynamic(i)

            String homeValue = writableSheet.getCell(0,i).getContents();
            String downPayment = writableSheet.getCell(1,i).getContents();
            String loanAmount = writableSheet.getCell(2,i).getContents();
            String startMonth = writableSheet.getCell(3,i).getContents();
            String startYear = writableSheet.getCell(4,i).getContents();



            Reusable_Methods.sendKeys(driver,"//*[@id='homeval']", homeValue," in Home Value");

            Reusable_Methods.sendKeys(driver,"//*[@id='downpayment']", downPayment," in Down Payment");

            Reusable_Methods.sendKeys(driver,"//*[@id='loanamt']", loanAmount," in Loan Amount");

            Reusable_Methods.dropDownMenu(driver,"//*[@name='param[start_month]']", startMonth," from Start Date month drop down");

            Reusable_Methods.sendKeys(driver,"//*[@id='start_year']", startYear," in Start Year");

            Reusable_Methods.click(driver,"//*[@value='Calculate']", " Calculate button");

            Thread.sleep(2000);

            String result = Reusable_Methods.captureText(driver, "//*[@class='left-cell']/following::h3[contains(text(),'$')]", "Monthly Payment Amount ");

            Label label = new Label(5,i,result);
            writableSheet.addCell(label);

        }

        writableFile.write();
        writableFile.close();

        driver.quit();
    }
}
