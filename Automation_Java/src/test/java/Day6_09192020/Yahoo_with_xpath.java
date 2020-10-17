package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Yahoo_with_xpath
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

        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@name= 'p']")).sendKeys("Hello World");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@value='Search']")).click();

        Thread.sleep(3000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,5000)");

        Thread.sleep(2000);

        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();

        String[] arrayResult = result.split("Next");

        String[] SearchResult = arrayResult[1].split(" ");

        System.out.println(SearchResult[0]);
        Thread.sleep(1000);

        jse.executeScript("scroll(0,-5000)");


        //driver.quit();

    }
}
