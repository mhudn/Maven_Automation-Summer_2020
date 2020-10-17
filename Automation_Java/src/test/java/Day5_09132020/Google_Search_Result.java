package Day5_09132020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Search_Result
{
    public static void main(String[] args) throws InterruptedException
    {
        //Set The ChromeDriver Location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //Defining a WebDriver named driver


        //maximizes the window
        //driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // here I'm passing an argument to have any driver already maximized when it opens

        WebDriver driver = new ChromeDriver(options);

        //options.addArguments("start-maximized", "incognito");

        //options.addArguments("headless");
/*
        //Opens a tab and goes to the address
        driver.get("https://www.fb.com");

        //setting delay before executing driver.navigate().to()
        Thread.sleep(5000);
*/
        //Navigate to a website using the ChromeDriver
        //Navigate opens tab in the same window when it is used inside a loop
        driver.navigate().to("https://www.google.com");

        //driver.findElement(By.id("q")); //unique
        driver.findElement(By.name("q")).sendKeys("Automation is Amazing"); //names are usually unique
        Thread.sleep(2000);
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("btnK")).submit(); //submit() is used as Enter Button
        //driver.findElement(By.className("q"));
        //setting delay before executing driver.close(); or driver.quit()
        Thread.sleep(5000);
        //driver.close();

        //Getting a certain string result and storing it in searchResult variable
        String searchResult = driver.findElement(By.id("result-stats")).getText();
        //defining a string array called splitResult
        String[] splitResult;
        //using the Split result method to split the searchResult
        splitResult= searchResult.split(" ");

        //printing out a specific index from string array
        System.out.println("\nTotal number of results is: " + splitResult[1]);

        //quitting the driver
        driver.quit();
    }
}
