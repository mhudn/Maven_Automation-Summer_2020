package Day6_09192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Yahoo_with_findElements
{
    public static void main(String[] args) throws InterruptedException {
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

        Thread.sleep(200);

        WebElement searchField;
        searchField = driver.findElement(By.xpath("//*[@name= 'p']"));

        searchField.clear(); //clears anything that in the search box
        searchField.sendKeys("Cars");//writes a text in the search box
        searchField.submit(); //Presses enter,

        //driver.findElements(By.xpath("//*[@class='_yb_e4mte']")).get(2).click();
        //get(2)
    }
}
