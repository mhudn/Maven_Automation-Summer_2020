package Day5_09132020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Array_Results
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //defining a ChromeOption variable named options

        // here I'm passing an argument to have any driver/browser already maximized when it opens
        options.addArguments("incognito");

        /*
        Don't want to maximize the window because I have ultra-wide Monitor and
        I don't like it full screen
        //options.addArguments("start-maximized");
         */

        //options.addArguments("start-maximized", "incognito","headless");
        //passing multiple arguments in a single option.

        //options.addArguments("headless");
        //runs the code and do the automation in the background without GUI

        //Defining a WebDriver named driver
        WebDriver driver = new ChromeDriver(options);

        //lets create a dynamic array to handle multiple borough on google search
        String[] boroughs = new String[5];
        boroughs[0] = "Brooklyn";
        boroughs[1] = "Queens";
        boroughs[2] = "Manhattan";
        boroughs[3] = "Manhattan";
        boroughs[4] = "Bronx";

        for(int i = 0; i < boroughs.length; i++)
        {
            driver.navigate().to("https:www.google.com");
            driver.findElement(By.name("q")).sendKeys(boroughs[i]); //names are usually unique
            Thread.sleep(2000); //setting delay by 2secs

            //driver.findElement(By.name("btnK")).click();
            driver.findElement(By.name("btnK")).submit(); //submit() is used as Enter Button

            Thread.sleep(3000); //3sec delay

            //Getting a certain string result and storing it in searchResult variable
            String searchResult = driver.findElement(By.id("result-stats")).getText();
            //defining a string array called splitResult
            String[] splitResult;
            //using the Split result method to split the searchResult
            splitResult= searchResult.split(" ");

            //printing out a specific index from string array
            System.out.println("\nTotal number of search result for " + boroughs[i] + " is: " + splitResult[1]);
        }

        driver.quit();



    }
}
