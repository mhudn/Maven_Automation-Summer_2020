package Reusable_Libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Methods
{
    static int timeOut = 10;
    public static void switchTab(WebDriver driver,int index) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        Thread.sleep(2000);
    }


    public static WebDriver getDriver()
    {

        //setting the location of the chromedriver.exe
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //defining ChromeOptions to enable pre-defined processes/arguments
        ChromeOptions options = new ChromeOptions();

        //passing through an argument to maximize the window that will be opened by WebDriver
        ///options.addArguments("start-maximized");
        //passing through an argument to open an incognito window by WebDriver
        options.addArguments("incognito");

        //executes the operation/code/script in the background without showing any GUI (Graphical User Interface.)
        //options.addArguments("headless");


        /*
        Defining a WebDriver variable called driver, which opens the chromedriver.exe and passing
        options as a argument to execute  "start-maximized" which makes the browser/driver fullscreen
        */
        WebDriver driver = new ChromeDriver(options);

        //driver.manage().deleteAllCookies();

        return driver;
    }


    public static void checkTitle(WebDriver driver, String webAddress, String expectedTitle)
    {

        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        driver.navigate().to(webAddress);

        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle))
        {
            System.out.println("\nHome page title contains: " + expectedTitle + "\nActual title is = " + actualTitle);
        }
        else
        {
            System.out.println("\nHome page title DOES NOT contain: " + expectedTitle + "\nActual title is = " + actualTitle);
        }
    }


    //method to click on any button
    public static void click(WebDriver driver, String locator, String elementName)
    {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        try
        {
            System.out.println("\nClicking on " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to click on " + elementName + err);
        }
    }



    //method to enter values
    public static void sendKeys(WebDriver driver, String locator, String userInput, String elementName)
    {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        try
        {
            System.out.println("\nEntering " + userInput + elementName);
            WebElement inputValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            inputValue.clear();
            inputValue.sendKeys(userInput);
            //Thread.sleep(1000);
            //inputValue.sendKeys(Keys.ENTER);
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to Enter " + userInput + elementName + err);
        }
    }



    //method for clicking submit or hitting Enter Key
    public static void submit(WebDriver driver, String locator, String elementName)
        {
            //define explicit wait
            WebDriverWait wait = new WebDriverWait(driver,timeOut);

            try
            {
                System.out.println("\nHitting Submit " + elementName);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
            }
            catch (Exception err)
            {
                System.out.println("\nUnable to hit submit \n" + err);
            }
        }

    //method for capturing texts from the web
    public static String captureText(WebDriver driver, String locator, String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String text = "";
        try
        {
            System.out.println("\nCapturing " + elementName);
            text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
            System.out.println(text);
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to capture " + elementName + err);
        }
        return text;
    }


    //method to select from drop down menu
    public static void dropDownMenu(WebDriver driver, String locator, String userInput, String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        try
        {
            System.out.println("\nSelecting " + userInput + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown= new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);

        }
        catch (Exception err)
        {
            System.out.println("\nUnable to select " + userInput + " from drop down \n" + err);
        }
    }


    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try
        {
            System.out.println("\nEntering " + userInput + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to Enter " + userInput + elementName + err);
        }
    }//end of type and submit method



    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try
        {
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        }
        catch (Exception err)
        {
            System.out.println("Unable to click by index " + index + " on element " + elementName + " " + err);
        }
    }


    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception err) {
            System.out.println("Unable to mouse click element " + elementName + " " + err);
        }
    }//end of click method

}
