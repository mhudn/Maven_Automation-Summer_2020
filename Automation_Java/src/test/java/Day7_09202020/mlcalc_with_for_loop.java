package Day7_09202020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class mlcalc_with_for_loop
{
    public static void main(String[] args) throws InterruptedException {
        //Set The ChromeDriver Location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //defining a ChromeOption variable named options

        // here I'm passing an argument to have any driver/browser already maximized when it opens
        //options.addArguments("start-maximized");

        //options.addArguments("start-maximized", "incognito","headless");
        //passing multiple arguments in a single option.

        //options.addArguments("headless");
        //runs the code and do the automation in the background without GUI

        //Defining a WebDriver named driver
        WebDriver driver = new ChromeDriver(options);
        //options variable should be passed inside the ChromeDriver


        ArrayList<String> pPriceList = new ArrayList();
        pPriceList.add("350000");
        pPriceList.add("400000");

        ArrayList<String> dPaymentList = new ArrayList();
        dPaymentList.add("30");
        dPaymentList.add("50");

        for(int i = 0; i < pPriceList.size(); i++)
        {
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);

            try
            {
                System.out.println("Entering new value on Purchase Price");
                WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
                Thread.sleep(2000);
            }
            catch (Exception err)
            {
                System.out.println("Unable to enter value on Purchase Price" + err);
            }



            try
            {
                System.out.println("Entering new value on Down Payment");
                WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
                dPayment.clear();
                dPayment.sendKeys(dPaymentList.get(i));
                Thread.sleep(2000);
            }
            catch (Exception err)
            {
                System.out.println("Unable to enter value on Down Payment" + err);
            }

            try
            {
                System.out.println("Clicking on Calculate button");
                driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
                Thread.sleep(2000);
            }
            catch (Exception err)
            {
                System.out.println("Unable to click Calculate button" + err);
            }

            try
            {
                System.out.println("Capturing monthly payment");
                String mntPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
                System.out.println("Your monthly payment is: " + mntPayment + "\n");
                Thread.sleep(2000);
            }
            catch (Exception err)
            {
                System.out.println("Unable to capture monthly payment" + err);
            }
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
