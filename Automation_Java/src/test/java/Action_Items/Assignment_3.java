package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment_3 //automating some manual searches using Bing search engine
{
    public static void main(String[] args) throws InterruptedException {
        //setting the location of the chromedriver.exe
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //defining ChromeOptions to enable pre-defined processes/arguments
        ChromeOptions options = new ChromeOptions();

        //passing through an argument to maximize the window that will be opened by WebDriver
        options.addArguments("start-maximized");
        //passing through an argument to open an incognito window by WebDriver
        options.addArguments("incognito");

        //executes the operation/code/script in the background without showing any GUI (Graphical User Interface.)
        //options.addArguments("headless");


        /*
        Defining a WebDriver variable called driver, which opens the chromedriver.exe and passing
        options as a argument to execute  "start-maximized" which makes the browser/driver fullscreen
        */
        WebDriver driver = new ChromeDriver(options);

        /*
        Things to remember here:
        ChromeOptions has to be defined and arguments should be passed before defining the
        WebDriver variable in order to arguments work.
         */


        //defining an array that holds 5 Hobbies in the String Array variable named Hobbies
        String[] Hobbies = new String[5];
        Hobbies[0] = "Calligraphy";
        Hobbies[1] = "Stand-up comedy";
        Hobbies[2] = "Kite flying";
        Hobbies[3] = "Playing musical instruments";
        Hobbies[4] = "Hiking";


        //iterating through each elements of Hobbies
        for(int i = 0; i < Hobbies.length; i++)
        {
            /*
        Now we have to navigate to the search engine that we have to execute test cases on.
        In this case it is: https://www.bing.com
         */

            //navigating to https://www.bing.com using the WebDriver
            driver.navigate().to("https://www.bing.com");
            //driver.get("https://www.bing.com");

            //writing the each hobbies in the search box(named as q) on "https://www.bing.com"
            driver.findElement(By.name("q")).sendKeys(Hobbies[i]);

            //adding 2sec delay
            Thread.sleep(2000);

            /*
            submit() is used as Enter Button on keyboard
            as well as clicking as the search icon
             */
            driver.findElement(By.name("search")).submit();


            /*
            Capturing the total number of results found which is
            stored in "sb_count" and we are storing that in the
            String searchResult variable.
             */
            String searchResult = driver.findElement(By.id("b_tween")).getText();


            //defining a string array called splitResult
            String[] splitSearchResult;

            //using the Split result method to split the searchResult
            splitSearchResult = searchResult.split(" ");

            //Prints out the name of the hobby and number of results found
            System.out.println("\nTotal number of search result for " + Hobbies[i] + " is: " + splitSearchResult[0]);

            //adding 2sec delay
            Thread.sleep(3000);
        }

        //Quits the browser completely
        driver.quit();

    }
}
