package Day12_10102020;

import Reusable_Libraries.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions
{
    @Test
    public void assertions() throws InterruptedException {
        WebDriver driver = Reusable_Methods.getDriver();
        driver.navigate().to("https://google.com");
        Thread.sleep(2000);


        //Hard Assert
        //Assert.assertEquals("GOOGLE", driver.getTitle());


        //soft assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"GOOGLE");


        Reusable_Methods.sendKeys(driver,"//*[@name='q']","cars","");

        softAssert.assertAll(); //stores all the error from the console
    }
}
