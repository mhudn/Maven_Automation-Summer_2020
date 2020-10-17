package Action_Items;

import Reusable_Libraries.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;

public class Assignment_4
{
    public static void main(String[] args) throws InterruptedException
    {
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

        driver.navigate().to("https://www.weightwatchers.com");

        String actualTitle = driver.getTitle();

        String expectedTitle = "Weight Watchers: Weight Loss & Wellness Help";
        System.out.println("\nExpected title is: \n" + expectedTitle);

        if(actualTitle == expectedTitle)
        {
            System.out.println("\nThe title matched with expected title");
        }
        else
        {
            System.out.println("\nThe actual title did not match with expected title! \nThe actual title is: \n" + actualTitle);
        }

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11230");
        zipCode.add("10452");
        zipCode.add("11101");


        for(int i = 0; i < zipCode.size(); i++)
        {

            try
            {
                driver.navigate().to("https://www.weightwatchers.com");
                System.out.println("\n\n\nNavigating to https://www.weightwatchers.com");
            }
            catch (Exception err)
            {
                System.out.println("\nCould not navigate to https://www.weightwatchers.com\n" + err);
            }
            Thread.sleep(2000);


            try
            {
                System.out.println("\nClicking on 'Find a Workshop' button");
                driver.findElement(By.xpath("//*[@da-action='nav_header_find-a-workshop']")).click();
            }
            catch (Exception err)
            {
                System.out.println("\nUnable to Click on 'Find a Workshop' button\n" + err);
            }
            Thread.sleep(2000);


            try
            {
                System.out.println("\nEntering zipcode " + zipCode.get(i) + " in the 'Enter location' box.");
                WebElement location = driver.findElement(By.xpath("//*[@id='location-search']"));
                location.clear();
                location.sendKeys(zipCode.get(i));
                Thread.sleep(2000);
            }
            catch (Exception err)
            {
                System.out.println("\nUnable to enter " + zipCode.get(i) + " in the 'Enter location' box.\n" + err);
            }


            try
            {
                System.out.println("\nClicking on Search (right arrow) button or pressing Enter key on Keyboard.");
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
                Thread.sleep(2000);
            }
            catch (Exception err)
            {
                System.out.println("Unable to click on Search (right arrow) button or press Enter key on Keyboard. . ." + err);
            }

            System.out.println("\nScrolling down 500 pixels . . .");
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(0,500)");
            Thread.sleep(2000);


            if(i == 0)
            {
                try
                {
                    System.out.println("\nClicking on the second link. . . ");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();
                    Thread.sleep(3000);

                }
                catch (Exception err)
                {
                    System.out.println("\n The second link is not found.");
                }
            }

            else if(i == 1)
            {
                try
                {
                    System.out.println("\nClicking on the third link. . . ");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                    Thread.sleep(3000);
                }
                catch (Exception err)
                {
                    System.out.println("\n The third link is not found.");
                }
            }

            else if (i == 2)
            {
                try
                {
                    System.out.println("\nClicking on the first link. . . ");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
                    Thread.sleep(3000);


                }
                catch (Exception err)
                {
                    System.out.println("\n The first link is not found.\n");
                }
            }

            try
            {
                String name = driver.findElements(By.xpath("//*[@class='locationName-1jro_']")).get(0).getText();
                System.out.println("\nCapturing Name: ");
                System.out.println(name);
                Thread.sleep(3000);

                String address1 = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(0).getText();
                String address2 = driver.findElements(By.xpath("//*[@class='oneLine-1Py5V']")).get(1).getText();
                System.out.println("\nCapturing Address: ");
                System.out.println(address1 + address2);
                Thread.sleep(3000);

                System.out.println("\nScrolling down 500 pixels . . .");
                jse.executeScript("scroll(0,500)");
                Thread.sleep(3000);

                /*String schedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(0).getText();
                System.out.println("\nCapturing Schedules: ");
                System.out.println(schedule);*/
                Reusable_Methods.captureText(driver, "//*[@class='scheduleContainerMobile-1RfmF']", "Schedules ");
            }
            catch (Exception err)
            {
                System.out.println("\n\t***Error!!***\n" + err);
            }

        } //end of for loop

        Thread.sleep(5000);
        driver.quit();
    } //end of main method
}
