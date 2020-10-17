package Rabu_Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_findelements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        //navigate to yahoo page
        driver.navigate().to("http://www.yahoo.com");
        Thread.sleep(2000);


        WebElement searchField = driver.findElement(By.xpath("//*[@name='p']"));
        //clear ant pre defined value on the field
       // searchField.clear();
        //enter your new keyword
       // searchField.sendKeys("cars");
        //submit on the same field
        // searchField.submit();
        //using find element to click on 3rd link(news)

         driver.findElements(By.xpath("//*[@class='_yb_e4mte ']")).get(2).click();
        driver.quit();


    }//end method
}//end java
