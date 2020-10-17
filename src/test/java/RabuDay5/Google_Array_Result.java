package RabuDay5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Array_Result {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the WebDriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        //lets create dynamic array to handle multiple

        String[] boroughs = new String[5];
        boroughs[0] = "Brooklyn";
        boroughs[1] = "Queens";
        boroughs[2] = "Manhattan";
        boroughs[3] = "Staten Island";
        boroughs[4] = "Bronx";


        for (int i = 0; i < boroughs.length; i++) {
            //let's navigate to google home page
            driver.navigate().to("http://www.google.com");

            Thread.sleep(2000);
            //click on google search
            driver.findElement(By.name("q")).sendKeys(boroughs[i]);
            driver.findElement(By.name("btnK")).submit();//hitting enter same as submit
            //delay to load search result page
            Thread.sleep(3000);
            String result = driver.findElement(By.id("result-stats")).getText();
            String[] arrayResult = result.split(" ");
            //print out the search number
            System.out.println("my search number is " +boroughs[i] + " is " + arrayResult[1]);


        }//end for loop
        // close driver
        // driver.close()
        // quit the entire session
        driver.quit();

    }//end main method
}//end java class
