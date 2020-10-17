package Actionitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment_3 {

    public static void main(String[] args) throws InterruptedException {
        // set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the defining the driver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        //lets create dynamic array to handle multiple

        String[] states = new String[5];
        states[0] = "NewYork";
        states[1] = "NewJersey";
        states[2] = "California";
        states[3] = "Florida";
        states[4] = "Georgia";


        for (int i = 0; i < states.length; i++) {
            //let's navigate to bing home page
            driver.navigate().to("http://www.bing.com");

            Thread.sleep(2000);
            //click on bing search
            driver.findElement(By.name("q")).sendKeys(states[i]);
           // driver.findElement(By.name("go")).submit();//hitting enter same as submit
            driver.findElement(By.name("q")).submit();
            //delay to load search result page
            Thread.sleep(3000);
            String result = driver.findElement(By.id("b_tween")).getText();
            String[] arrayResult = result.split(" ");
            //print out the search number
            System.out.println("my searching states is " + states[i] + " is " + arrayResult[0]);


        }//end for loop
        // close driver
        // driver.close();
        // quit the entire session
        driver.quit();

    }//end main method
}//end java class





