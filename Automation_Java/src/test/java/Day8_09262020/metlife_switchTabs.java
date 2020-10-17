package Day8_09262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class metlife_switchTabs
{
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

        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();

        driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        driver.findElement(By.xpath("//*[@name='txtZipCode']")).sendKeys("11230");
        driver.close(); //closes the 2nd tab

        driver.switchTo().window(tabs.get(0)); //switches to the first tab

        driver.navigate().to("https://www.metlife.com");


        Thread.sleep(5000);
        driver.quit();
    }
}
