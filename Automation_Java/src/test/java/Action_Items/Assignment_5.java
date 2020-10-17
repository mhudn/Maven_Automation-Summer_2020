package Action_Items;

import Reusable_Libraries.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Assignment_5
{
    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //setting the chrome options before defining the driver
        ChromeOptions options = new ChromeOptions();

        //set the driver to be maximized
        //options.addArguments("start-maximized");

        //set the driver to be incognito mode(private)
        options.addArguments("incognito");

        //run the driver in headless mode
        //options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options); //options variable should be passed here

        driver.navigate().to("https://www.uhc.com");

        String actualTitle = driver.getTitle();

        //System.out.println(actualTitle);



        //                      DID NOT WORK
/*
        String[] splitTitle = actualTitle.split(" ");

        if (splitTitle[0] == "Health" && splitTitle[1] == "insurance" && splitTitle[2] == "plans")
        {
            System.out.println(actualTitle + "\nHome page title contains: Health insurance plans");
        }

        //Only else did not work so I tried with else if

        else if (splitTitle[0] != "Health" && splitTitle[1] != "insurance" && splitTitle[2] != "plans")
        {
            System.out.println(actualTitle + "\nHome page title does NOT contain: Health insurance plans");
        }
*/
        System.out.println("\n\n------------------------------------------\n\n");

        if(actualTitle.contains("Health insurance plans"))
        {
            System.out.println(actualTitle + "\nHome page title contains: Health insurance plans");
        }
        else
        {
            System.out.println(actualTitle + "\nHome page title DOES NOT contain: Health insurance plans");
        }


        /*try
        {
            System.out.println("\nClicking on 'Find a Doctor' button");
            driver.findElement(By.xpath("//*[@aria-label='Find a Doctor']")).click();
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to Click on 'Find a Doctor' button\n" + err);
        }
        Thread.sleep(2000);
        */

        //firstNames
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Jaylen");
        firstName.add("Clayton");
        firstName.add("Stephen");

        //lastNames
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Holden");
        lastName.add("Abbott");
        lastName.add("Franco");

        //DOBs
        /*ArrayList<String> dateOfBirth = new ArrayList<>();
        dateOfBirth.add("11/02/1988");
        dateOfBirth.add("03/25/1996");
        dateOfBirth.add("08/19/2000");*/

        ArrayList<String> dob_month = new ArrayList<>();
        dob_month.add("November");
        dob_month.add("March");
        dob_month.add("August");

        ArrayList<String> dob_day = new ArrayList<>();
        dob_day.add("02");
        dob_day.add("25");
        dob_day.add("19");

        ArrayList<String> dob_year = new ArrayList<>();
        dob_year.add("1988");
        dob_year.add("1996");
        dob_year.add("2000");



        //Last 6 digits of Social Security Number
        ArrayList<String> SSN = new ArrayList<>();
        SSN.add("88-2076");
        SSN.add("90-3498");
        SSN.add("58-8316");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11230");
        zipCode.add("10452");
        zipCode.add("11101");


        for(int i = 0; i < SSN.size(); i++)
        {
            System.out.println("\n\n------------------------------------------\n");

            driver.navigate().to("https://www.uhc.com");

            Reusable_Methods.click(driver,"//*[@aria-label='Find a Doctor']","'Find a Doctor'");

            Reusable_Methods.click(driver,"//*[@id='btn-sign-in']","'Sign in to Find a Doctor'");


            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(2000);

            Reusable_Methods.click(driver,"//*[@id='registerbutton']","'Register Now'");

            Reusable_Methods.sendKeys(driver, "//*[@name='firstName']",firstName.get(i)," on 'First name' box");
            Reusable_Methods.sendKeys(driver, "//*[@name='lastName']",lastName.get(i)," on 'Last name' box");

            System.out.println("\n\nEntering Date of Birth: . . . ");
            Reusable_Methods.dropDownMenu(driver, "//*[@id='dob_month_input']",dob_month.get(i)," from Month drop down menu");
            Reusable_Methods.sendKeys(driver, "//*[@id='dob_day']",dob_day.get(i)," on day box");
            Reusable_Methods.sendKeys(driver, "//*[@id='dob_year']",dob_year.get(i)," on year box");

            Reusable_Methods.click(driver,"//*[@for='ssn']","'Social Security Number' for Identification Type");

            Reusable_Methods.sendKeys(driver, "//*[@id='ssnLastSixDigits']",SSN.get(i)," on 'Last 6 digits of your Social Security Number' box");

            Reusable_Methods.sendKeys(driver, "//*[@id='zipCode']",zipCode.get(i)," on 'Zip code' box");

            Reusable_Methods.click(driver,"//*[@id='submitBtn']","'Continue'");

            Reusable_Methods.captureText(driver,"//*[@id='plainText_error']","Error message: ");

            Thread.sleep(2000);
            driver.close(); //closes current tab
            driver.switchTo().window(tabs.get(0)); //switches to the first tab
        }
        //Thread.sleep(5000);
        driver.quit();
    }
}
