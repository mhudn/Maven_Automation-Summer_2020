package All_Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AI3_Practice //automating some manual searches using Bing search engine
{
    public static void main(String[] args) throws InterruptedException {
        //setting the location of the chromedriver.exe
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //defining ChromeOptions to enable pre-defined processes/arguments
        ChromeOptions options = new ChromeOptions();

        //passing through an argument to maximize the window that will be opened by WebDriver
        //options.addArguments("start-maximized");
        options.addArguments("incognito");

        //executes the operation/code/script in the background without showing any GUI (Graphical User Interface.)
        options.addArguments("headless");


        /*
        Defining a WebDriver variable called driver, which opens the chromedriver.exe and passing
        options as a argument to execute  "start-maximized" which makes the browser/driver fullscreen
        */
        WebDriver driver = new ChromeDriver(options);

        /*
        Things to remember here:
        ChromeOptions has to be defined and arguments should be passed before defining the
        WebDriver variable in order to arguments work.
         */



        //defining an array that holds multiple Hobbies in the String Array variable named Hobbies
        /*
        Avoiding:
        "Acting", "cooking", "Crocheting","Dance","Electronics","Fashion","Role-playing games",
        "Origami","Reading","Video gaming",,"Model building","Watching movies",,"Backpacking",
        "Blacksmithing","Geocaching","Gardening","Ghost hunting","Hunting","Mountain biking",
        "Mountaineering","Rugby","Letterboxing","Netball","Inline skating",,"Scouting"
         */
        String[] Hobbies = new String[]
                {
                        "3D printing","Amateur radio","Scrapbook","Amateur radio","Baton twirling",
                        "Board games","Book restoration","Cabaret","Calligraphy","Candle making",
                        "Computer programming","Coffee roasting","Colouring","Cosplaying",
                        "Couponing","Creative writing","Cryptography","Digital arts",
                        "Drama","Drawing","Do it yourself","Embroidery","Brazilian jiu-jitsu",
                        "Flower arranging","Foreign language learning","Gaming","Tabletop games"
                        ,"Gambling","Genealogy","Glassblowing","Gunsmithing","Lego building",
                        "Homebrewing","Ice skating","Jewelry making","Jigsaw puzzles","Juggling","Knapping",
                        "Knitting","Kabaddi","Knife making","Lacemaking","Lapidary","Leather crafting",
                        "Lockpicking","Machining","Macrame","Metalworking","Magic",
                        "Listening to music","Painting","Playing musical instruments",
                        "Pet","Poi","Pottery","Puzzles","Quilting","Scrapbooking",
                        "Sculpting","Sewing","Singing","Sketching","Soapmaking","Sports",
                        "Stand-up comedy","Sudoku","Table tennis","Taxidermy",
                        "Web surfing","Whittling","Wood carving","Woodworking",
                        "World Building","Writing","Yoga","Yo-yoing","Air sports","Archery",
                        "Astronomy","Base jumping","Baseball","Basketball","Beekeeping",
                        "Bird watching","Board sports","Bodybuilding","Cycling","Dowsing","Driving","Fishing",
                        "Flag football","Flying","Flying disc","Foraging",
                        "Graffiti","Handball","Hiking","Hooping","Horseback riding","Hunting",
                        "Jogging","Kayaking","Kite flying","Kitesurfing","Larping",
                        "Metal detecting","Motor sports",
                        "Mushroom hunting","Nordic skating",
                        "Orienteering","Paintball","Parkour","Photography","Polo","Rafting",
                        "Rappelling","Rock climbing","Roller skating","Running","Sailing",
                        "Sand art","Scuba diving","Sculling","Rowing","Shooting",
                        "Shopping","Skateboarding","Skiing","Skim Boarding","Skydiving",
                        "Slacklining","Snowboarding","Stone skipping","Surfing","Swimming","Taekwondo",
                        "Tai chi","Urban exploration","Vacation","Vehicle restoration","Water sports"
                };

        //figuring/printing out how many indexes I have in the Hobbies array
        System.out.println("Number of elements in the Hobbies Array: " + Hobbies.length);


        //iterating through each elements of Hobbies
        for(int i = 0; i < Hobbies.length; i++)
        {
            /*
        Now we have to navigate to the search engine that we have to execute test cases on.
        In this case it is: https://www.bing.com
         */

            //navigating to https://www.bing.com using the WebDriver
            driver.navigate().to("https://www.bing.com");
            //driver.get("https://www.bing.com");

            //writing the each hobbies in the search box(named as q) on "https://www.bing.com"
            driver.findElement(By.name("q")).sendKeys(Hobbies[i]);


            /*
            submit() is used as Enter Button on keyboard
            as well as clicking as the search icon
             */
            driver.findElement(By.name("search")).submit();


            /*
            Capturing the total number of results found which is
            stored in "sb_count" and we are storing that in the
            String searchResult variable.
             */
            String searchResult = driver.findElement(By.id("b_tween")).getText();


            //defining a string array called splitResult
            String[] splitSearchResult;
            //using the Split result method to split the searchResult
            splitSearchResult = searchResult.split(" ");


            if(splitSearchResult[0] != "Results" || splitSearchResult[0] != "Near" || splitSearchResult[1] != "Near")
            //doesn't read the if statement
            {
                System.out.println("\nTotal number of search result for " + Hobbies[i] + " is: " + splitSearchResult[0]);
            }


            //adding 2sec delay
            //Thread.sleep(2000);
        }


        //driver.close();
        //Quits the browser completely
        driver.quit();

    }
}
