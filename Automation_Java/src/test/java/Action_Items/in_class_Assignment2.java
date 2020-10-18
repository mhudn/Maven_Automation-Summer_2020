package Action_Items;

import Reusable_Libraries.Abstract_Class;
import Reusable_Libraries.Reusable_Methods;
import Reusable_Libraries.Reusable_Methods_Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class in_class_Assignment2 extends Abstract_Class
{
    @Test
    public void YahooInClass() throws InterruptedException
    {
        Reusable_Methods_Loggers.checkTitle(driver,"https://yahoo.com","Yahoo");

        driver.navigate().to("https://yahoo.com");
        Thread.sleep(2000);


        List<WebElement> linkCount = driver.findElements(By.xpath("//*[@class='_yb_e0gik']"));

        System.out.println("Link count is:" + linkCount.size());

        Reusable_Methods_Loggers.sendKeys(driver,"//*[@name='p']","Nutrition",logger,"Nutrition in search box");
        Reusable_Methods_Loggers.submit(driver,"//*[@value='Search']",logger," Hitting Enter");
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,5000)");

        String result = Reusable_Methods_Loggers.captureText(driver,"//*[@class='compPagination']",logger,"capturing search result");

        String[] arrayResult = result.split("Next");

        String[] SearchResult = arrayResult[1].split(" ");

        System.out.println(SearchResult[0]);

        Thread.sleep(1000);

        jse.executeScript("scroll(0,-5000)");

        Reusable_Methods.click(driver,"//*[@class='fl-l mr-5 last']", "Clicking on images");
        Thread.sleep(5000);








        /*//clicking on sign in button
        Reusable_Methods.click(driver,"//*[@class='_yb_687jt']","Sign In button");
        Thread.sleep(2000);

        //Stay Sign in checkbox
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();*/
    }
}
