package Day9_09272020;

import Reusable_Libraries.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Reusable_Methods_with_AppleDotCom
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


        driver.navigate().to("https://www.apple.com");
        Thread.sleep(2000);



        Reusable_Methods.click(driver,"//*[@data-analytics-title='mac']","Mac Link");




        Thread.sleep(2000);
        Reusable_Methods.click(driver,"//*[text()='MacBook Air']","MacBook Air Link");
        Thread.sleep(2000);
        Reusable_Methods.click(driver,"//*[@id='ac-gn-link-search']", "on Search Icon");
        Thread.sleep(2000);
        Reusable_Methods.sendKeys(driver, "//*[@id='ac-gn-searchform-input']","iPhone","on Search Field");
        Thread.sleep(2000);
        Reusable_Methods.submit(driver,"//*[@id='ac-gn-searchform-input']","on Search Field");


        Thread.sleep(2000);
        driver.quit();
    }
}
