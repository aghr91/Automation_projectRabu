package Reusable_Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReusableMethod_Apple {
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
        driver.navigate().to("http://www.apple.com");

        //calling the reusable click method for clicking on mac link
        Reusable_method.click(driver,"//*[@data-analytics-title='mac']","mac");
        //click on mac book air
        Reusable_method.click(driver,"//*[text()='MacBook Air']","Mac Book Air");
        //click on search icon
        Thread.sleep(2000);
        Reusable_method.click(driver,"//*[@id='ac-gn-link-search']","search icon");
        //entering a keyword on search field
        Reusable_method.sendkeys(driver,"//*[@placeholder='Search apple.com']","iphone","Search Field");
        Thread.sleep(1500);
        //hit submit
         Reusable_method.submit(driver,"//*[@placeholder='Search apple.com']","Search Field");


         driver.quit();




    }//end main method
}//end java
