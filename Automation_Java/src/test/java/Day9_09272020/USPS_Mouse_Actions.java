package Day9_09272020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class USPS_Mouse_Actions
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

        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //Declaring Mouse Actions command
        Actions actions = new Actions(driver);

        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        actions.moveToElement(quickTools).perform();

        WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        actions.moveToElement(trackPackage).click().perform();

        Thread.sleep(2500);

        WebElement trackNumber = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        //actions.moveToElement(trackNumber).sendKeys("876543213456789").perform();
        trackNumber.sendKeys("98765432123456789");




        Thread.sleep(5000);
        driver.quit();
    }
}
