package Reusable_Libraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Reusable_Methods_Loggers
{
    static int timeOut = 10;
    public static void switchTab(WebDriver driver,int index) throws InterruptedException
    {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        Thread.sleep(2000);
    }


    public static WebDriver getDriver() throws IOException, InterruptedException {


        //kill all chrome driver instance before opening a new one
        Thread.sleep(1000);
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        //mac/windows
        //Runtime.getRuntime().exec("pgrep 'chromedriver' | xargs kill");
        //another way
        /*
        String cmds[] = {"killall","chromedriver"};
        Runtime.getRuntime().exec(cmds)
         */

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


    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,ExtentTest logger,String imageName)
    {
        try
        {
            String fileName = imageName + ".png";
            String directory = "src/main/java/HTML_Report/Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture("Screenshots/" + fileName);
            logger.log(LogStatus.FAIL, "", image);
        }
        catch (Exception err)
        {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            err.printStackTrace();
        }
    }//end of screenshot method


    public static void checkTitle(WebDriver driver, String webAddress, ExtentTest logger, String expectedTitle)
    {

        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        driver.navigate().to(webAddress);

        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle))
        {
            logger.log(LogStatus.INFO,"Home page title contains: " + expectedTitle + "\nActual title is = " + actualTitle);
            System.out.println("\nHome page title contains: " + expectedTitle + "\nActual title is = " + actualTitle);
        }
        else
        {
            logger.log(LogStatus.FAIL,"Home page title DOES NOT contain: " + expectedTitle + "\nActual title is = " + actualTitle);
            System.out.println("\nHome page title DOES NOT contain: " + expectedTitle + "\nActual title is = " + actualTitle);
        }
    }


    //method to click on any button
    public static void click(WebDriver driver, String locator, ExtentTest logger, String elementName)
    {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        try
        {
            System.out.println("\nClicking on " + elementName);
            logger.log(LogStatus.INFO,"Clicking on " + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to click on " + elementName + err);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + err);
            getScreenShot(driver,logger,elementName);
        }
    }




    public static void clickByIndex(WebDriver driver,String locator,int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try
        {
            System.out.println("\nClicking by index " + index + " on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking by index " + index + " on element " + elementName);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index).click();
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to click by index " + index + " on element " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"Unable to click by index " + index + " on element " + elementName + " " + err);
            getScreenShot(driver,logger,elementName);
        }
    }


    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        Actions actions = new Actions(driver);
        try{
            System.out.println("\nMouse clicking a value on element " + elementName);
            logger.log(LogStatus.INFO,"Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception err) {
            System.out.println("\nUnable to mouse click element " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"Unable to mouse click element " + elementName + " " + err);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method


    //method to click on an element
    public static void mouseHover(WebDriver driver,String locator,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        Actions actions = new Actions(driver);
        try{
            System.out.println("\nHovering mouse on element " + elementName);
            logger.log(LogStatus.INFO,"Hovering mouse on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).perform();
        } catch (Exception err) {
            System.out.println("\nUnable to Hover mouse on element " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"Unable to Hover mouse on element " + elementName + " " + err);
            getScreenShot(driver,logger,elementName);
        }
    }//end of click method


    //method to enter values
    public static void sendKeys(WebDriver driver, String locator, String userInput, ExtentTest logger, String elementName)
    {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        try
        {
            System.out.println("\nEntering " + userInput + elementName);
            logger.log(LogStatus.INFO,"Entering " + userInput + elementName);
            WebElement inputValue = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            inputValue.clear();
            inputValue.sendKeys(userInput);
            //Thread.sleep(1000);
            //inputValue.sendKeys(Keys.ENTER);
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to Enter " + userInput + elementName + err);
            logger.log(LogStatus.FAIL,"Unable to Enter " + userInput + elementName + err);
            getScreenShot(driver,logger,elementName);
        }
    }



    //method for clicking submit or hitting Enter Key
    public static void submit(WebDriver driver, String locator, ExtentTest logger, String elementName)
        {
            //define explicit wait
            WebDriverWait wait = new WebDriverWait(driver,timeOut);

            try
            {
                System.out.println("\nHitting Submit " + elementName);
                logger.log(LogStatus.INFO,"Hitting Submit " + elementName);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();
            }
            catch (Exception err)
            {
                System.out.println("\nUnable to hit submit \n" + err);
                logger.log(LogStatus.FAIL,"Unable to hit submit " + err);
                getScreenShot(driver,logger,elementName);
            }
        }

    //method for capturing texts from the web
    public static String captureText(WebDriver driver, String locator, ExtentTest logger, String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        String text = "";
        try
        {
            System.out.println("\nCapturing " + elementName);
            text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
            System.out.println(text);
            logger.log(LogStatus.INFO,"Capturing " + elementName + " " + text);
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to capture " + elementName + err);
            logger.log(LogStatus.FAIL,"Unable to capture " + elementName + err);
            getScreenShot(driver,logger,elementName);
        }
        return text;
    }


    //method to select from drop down menu
    public static void dropDownMenu(WebDriver driver, String locator, String userInput, ExtentTest logger,String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);

        try
        {
            System.out.println("\nSelecting " + userInput + elementName);
            logger.log(LogStatus.INFO,"Selecting " + userInput + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown= new Select(dropDown);
            selectDropDown.selectByVisibleText(userInput);

        }
        catch (Exception err)
        {
            System.out.println("\nUnable to select " + userInput + " from drop down \n" + err);
            logger.log(LogStatus.FAIL,"Unable to select " + userInput + " from drop down " + err);
            getScreenShot(driver,logger,elementName);
        }
    }


    public static void typeAndSubmit(WebDriver driver,String locator, String userInput,ExtentTest logger, String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        try
        {
            System.out.println("\nEntering " + userInput + elementName);
            logger.log(LogStatus.INFO,"Entering " + userInput + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        }
        catch (Exception err)
        {
            System.out.println("\nUnable to Enter " + userInput + elementName + err);
            logger.log(LogStatus.FAIL,"Unable to Enter " + userInput + elementName + err);
            getScreenShot(driver,logger,elementName);
        }
    }//end of type and submit method


    //method to upload a file(image,doc, etc...) from your computer by using robot command
    public static void uploadFile(String filePath) throws AWTException
    {
        try
        {
            StringSelection ss = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
            Robot robot = new Robot();
            robot.delay(1000);
            //imitate mouse events like ENTER, CTRL+C, CTRL+V
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

        catch (Exception exp)
        {
            exp.printStackTrace();
        }

    }//end of upload file using Robot command

}
