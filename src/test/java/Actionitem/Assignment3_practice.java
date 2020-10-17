package Actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment3_practice {
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

        String[] hobbies = new String[5];
        hobbies[0] = "Fishing";
        hobbies[1] = "Cooking";
        hobbies[2] = "Gardening";
        hobbies[3] = "Gambling";
        hobbies[4] = "Swimming";


        for (int i = 0; i < hobbies.length; i++) {
            //let's navigate to google home page
            driver.navigate().to("http://www.bing.com");

            Thread.sleep(2000);
            //click on google search
            driver.findElement(By.name("q")).sendKeys(hobbies[i]);

           // driver.findElement(By.name("go")).submit();//hitting enter same as submit
            driver.findElement(By.name("q")).submit();

            //delay to load search result page
            Thread.sleep(3000);
            String result = driver.findElement(By.id("b_tween")).getText();
            String[] arrayResult = result.split(" ");
            //print out the search number
            System.out.println("my searching place is " +hobbies[i] + " is " + arrayResult[1]);


        }//end for loop
        // close driver
        // driver.close()
        // quit the entire session
        driver.quit();




    }//end main method
}//end of java class