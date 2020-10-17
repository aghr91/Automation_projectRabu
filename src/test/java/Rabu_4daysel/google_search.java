package Rabu_4daysel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search {


    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //defining the web driver that you will be using


        //let's get to google home page

        driver.get("http://www.google.com");
        //let's navigate to google home page
        driver.navigate().to("http://www.google.com");
        Thread.sleep(2000);
        // close driver
        // driver.close();
        // quit the entire session
        driver.quit();


    }//end method
}//end java
