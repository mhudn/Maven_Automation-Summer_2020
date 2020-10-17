package Day5_09132020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options
{
    public static void main(String[] args) throws InterruptedException {
        //Set The ChromeDriver Location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //defining a ChromeOption variable named options

        // here I'm passing an argument to have any driver/browser already maximized when it opens
        options.addArguments("start-maximized");

        //options.addArguments("start-maximized", "incognito","headless");
        //passing multiple arguments in a single option.

        //options.addArguments("headless");
        //runs the code and do the automation in the background without GUI

        //Defining a WebDriver named driver
        WebDriver driver = new ChromeDriver(options);
        //options variable should be passed inside the ChromeDriver

        driver.navigate().to("https://www.google.com");
        //opens chrome browser and navigates to google.com
        Thread.sleep(3000);

        //capture title of the current web page
        String actualTitle = driver.getTitle();

        /*
        an example:
        The requirements: Capture the homepage title and verify that it matches with the expected Title.
        Which is GOOGLE
         */
        System.out.println("The title in the webpage is: " + actualTitle);
        if(actualTitle == "GOOGLE")
        {
            System.out.println("Title matched.");
        }
        else
        {
            System.out.println("Title did not match. The expected title was: Google");
        }

        driver.quit();

        //maximizes the window
        //driver.manage().window().maximize();

    }
}
