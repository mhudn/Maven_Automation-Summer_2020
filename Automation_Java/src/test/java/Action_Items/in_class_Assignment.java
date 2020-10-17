package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class in_class_Assignment
{
    public static void main(String[] args) throws InterruptedException
    {
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

        //navigate to hotels
        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(1000);


        ArrayList<String> locations = new ArrayList<>();
        locations.add("Atlantic City, New Jersey");
        //locations.add("Disney Land");
        //locations.add("Bali, Indonesia");

        for(int i=0; i<locations.size(); i++)
        {
            try
            {
                System.out.println("Entering a new on Destination:");
                WebElement destination = driver.findElement(By.xpath("//*[@id='qf-0q-destination']"));
                //destination.clear();
                Thread.sleep(1000);
                destination.sendKeys("Atlantic City, New Jersey");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@class='autosuggest-category-result']")).click();
                Thread.sleep(1000);
            }

            catch (Exception err)
            {
                System.out.println("Unable to enter a new on Destination\n " + err);
            }


            //CheckIn
            try
            {
                System.out.println("Entering a new date on check in:");
                WebElement checkIn = driver.findElement(By.xpath("//*[@id='qf-0q-localised-check-in']"));
                checkIn.clear();
                Thread.sleep(1000);
                checkIn.sendKeys("10/28/20");
                Thread.sleep(1000);

            } catch (Exception err)
            {
                System.out.println("Unable to enter a new date on check in\n " + err);
            }

            //CheckOut
            try
            {
                System.out.println("Entering a new date on check out:");
                WebElement checkIn = driver.findElement(By.xpath("//*[@id='qf-0q-localised-check-out']"));
                checkIn.clear();
                Thread.sleep(1000);
                checkIn.sendKeys("11/03/20");
                Thread.sleep(1000);

            } catch (Exception err)
            {
                System.out.println("Unable to enter a new date on check out " + err);
            }

            //Rooms
            try{
                System.out.println("Selecting number of rooms");
                WebElement Room1 = driver.findElement(By.xpath("//*[@id='qf-0q-rooms']"));
                Select roomList = new Select(Room1);
                Thread.sleep(1000);
                roomList.selectByVisibleText("1");
                Thread.sleep(1000);
            } catch (Exception err) {
                System.out.println("Unable to select number of rooms" + err);
            }

            //Adults
            try{
                System.out.println("Selecting number of adults");
                WebElement Adults = driver.findElement(By.xpath("//*[@id='qf-0q-room-0-adults']"));
                Select roomList = new Select(Adults);
                Thread.sleep(1000);
                roomList.selectByVisibleText("6");
                Thread.sleep(1000);
            } catch (Exception err) {
                System.out.println("Unable to select number of adults " + err);
            }

            //Search
            System.out.println("Clicking on the search button");
            driver.findElement(By.xpath("//*[@class='cta cta-strong']")).click();
            //Thread.sleep(3000);

            System.out.println("\nScrolling down 500 pixels . . .");
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(0,500)");

            //Clicking on link
            try
            {
                System.out.println("Clicking on first link");
                driver.findElements(By.xpath("//*[@class='p-name']")).get(0).click();
                Thread.sleep(1000);
                Thread.sleep(1000);
            }
            catch(Exception err)
            {
                System.out.println("Unable to click on first link " + err);
            }


            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(tabs.get(1));

            System.out.println("Switching to the second tab");

            try
            {
                System.out.println("Capturing the name of the resort");
                //String resortName = driver.findElements(By.xpath("//*[@class='property-description']")).get(0).getText();
                //System.out.println(resortName);

                String resortName = driver.findElement(By.xpath("//*[@class='vcard']")).getText();

                //String[] onlyResortName = resortName.split(" ");

                System.out.println(resortName);

                //System.out.println("The name of the resort is: " + onlyResortName[0] + " " + onlyResortName[1] + " " + onlyResortName[2] + " " + onlyResortName[3] + " " + onlyResortName[4]);

            }
            catch (Exception err)
            {
                System.out.println("Unable to Capture the name of the resort " + err);
            }


            try
            {
                System.out.println("Capturing the price");

                String price = driver.findElement(By.xpath("//*[@class='price']")).getText();

                String[] priceInRed = price.split(" ");

                //System.out.println(priceInRed[1]);
                System.out.println(price);
            }
            catch (Exception err)
            {
                System.out.println("Unable to Capture the price " + err);
            }
        }
        //Destination







        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
