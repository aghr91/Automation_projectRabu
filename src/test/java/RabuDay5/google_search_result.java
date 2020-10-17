package RabuDay5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google_search_result {


    public static void main(String[] args) throws InterruptedException {
        //set the chrome driver location
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //defining the web driver that you will be using


        //let's get to google home page
        //driver.get("http://www.google.com");

        //let's navigate to google home page
        driver.navigate().to("http://www.google.com");

        Thread.sleep(2000);
        //click on google search
        //driver.findElement(By.name("btnK")).click();
        driver.findElement(By.name("btnK")).submit();//hitting enter same as submit
        //delay to load search result page
        Thread.sleep(3000);
        String result = driver.findElement(By.id("result-stats")).getText();
        String[] arrayResult = result.split(" ");
        //print out the search number
        System.out.println("my search number is " + arrayResult[1]);
        // close driver
        // driver.close();
        // quit the entire session
        driver.quit();


    }//end method
}//end java
