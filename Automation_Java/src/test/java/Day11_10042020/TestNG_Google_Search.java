package Day11_10042020;

import Reusable_Libraries.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Google_Search
{
    //call before suite to set up ChromeDriver
    //Pre-condition
    //driver need to be initialized outside of all methods so that it can be reusabl
    WebDriver driver = null;
    @BeforeSuite
    public void setChromeDriver()
    {
        driver = Reusable_Methods.getDriver();
    }

    @Test(priority = 1)
    public void searchKeyword() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        Reusable_Methods.sendKeys(driver,"//*[@name='q']","cars"," in search box");
        Reusable_Methods.submit(driver,"//*[@name='btnK']","on Search Button");
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void getSearchResult()
    {
        String result = Reusable_Methods.captureText(driver,"//*[@id='result-stats']","Result");
        System.out.println("My Search result is " + result);
    }

    @AfterSuite
    public void closeDriver()
    {
        driver.quit();
    }


}
