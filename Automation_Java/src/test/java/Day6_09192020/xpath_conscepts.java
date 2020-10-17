package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class xpath_conscepts
{
    public static void main(String[] args) throws InterruptedException
    {
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

        //driver.navigate().to("https://www.yahoo.com");
        //Thread.sleep(2000);

        //driver.findElement(By.xpath("//*[@id='ybar_sbq' or @name='p']")).sendKeys("cars");
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(2000);

        driver.findElements(By.xpath("//*[contains(@class, 'yb_e4mte')]")).get(2).click();
        //driver.findElements(By.xpath("//*[contains(@class, 'yb_e4mte')]")).get(2).submit();
        //driver.findElements(By.xpath("//*[contains(@class, 'yb_e4mte')]")).get(2).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();
    }

}
