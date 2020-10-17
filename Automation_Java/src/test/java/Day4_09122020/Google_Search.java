package Day4_09122020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Search
{
    public static void main(String[] args) throws InterruptedException
    {
        //Set The ChromeDriver Location
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //Defining a WebDriver named driver
        WebDriver driver = new ChromeDriver();

        //maximizes the window
        //driver.manage().window().maximize();
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
        /*Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click(); */
        driver.findElement(By.name("btnK")).submit(); //submit() is used as Enter Button
        //driver.findElement(By.className("q"));
        //setting delay before executing driver.close(); or driver.quit()
        Thread.sleep(5000);
        //driver.close();
        driver.quit();
    }
}
