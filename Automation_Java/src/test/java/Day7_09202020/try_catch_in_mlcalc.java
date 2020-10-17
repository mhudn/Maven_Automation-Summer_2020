package Day7_09202020;

import Reusable_Libraries.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class try_catch_in_mlcalc {

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

        //navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);

        //clear and enter purchase price
        try{
            System.out.println("Entering new value on Purchase Price");
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        } catch (Exception err) {
            System.out.println("Unable to enter value on Purchase Price " + err);
        }//end of purchase price exception

        Thread.sleep(2000);

        //clear and enter down payment
        try{
            System.out.println("Entering new value on Down Payment");
            WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));
            dPayment.clear();
            dPayment.sendKeys("40");
        } catch (Exception err) {
            System.out.println("Unable to enter value on down payment " + err);
        }//end of down payment exception

        Thread.sleep(2000);

        //Select a start month
     /*   try
        {
            System.out.println("Selecting a month no Start Month");
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smList = new Select(startMonth);
            smList.selectByVisibleText("Feb");
        } catch (Exception err)
        {
            System.out.println("Unable to select start month " + err);
        }*/

        Reusable_Methods.dropDownMenu(driver,"//*[@name='sm']","Feb", "Month");

        Thread.sleep(2000);

        //click on calculate
        try{
            System.out.println("Clicking on Calculate button");
            driver.findElement(By.xpath("//*[@alt='Calculate']")).click();
        } catch (Exception err) {
            System.out.println("Unable to click on Calculate button " + err);
        }//end of Calculate exception

        Thread.sleep(2000);
        driver.quit();
    }//end of main method

}//end of java class


