package Day12_10102020;

import Reusable_Libraries.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class List_and_Checkbox
{
    @Test
    public void verifications() throws InterruptedException {
        WebDriver driver = Reusable_Methods.getDriver();
        driver.navigate().to("https://yahoo.com");
        Thread.sleep(2000);

        List<WebElement> linkCount = driver.findElements(By.xpath("//*[@class='_yb_5coqv']"));

        System.out.println("Link count is:" + linkCount.size());


        //clicking on sign in button
        Reusable_Methods.click(driver,"//*[@class='_yb_687jt']","Sign In button");
        Thread.sleep(2000);

        //Stay Sign in checkbox
        boolean checkboxState = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();

        //expecting the checkbox to be selected
        if (checkboxState == true)
        {
            System.out.println("Checkbox is selected as expected");
        }
        else
        {
            System.out.println("Checkbox is not selected by default");
        }
    }
}
