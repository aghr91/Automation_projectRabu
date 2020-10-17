package Rabuday_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Metlife_swith {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");
        //run the driver at headless mode
        // options.addArguments("headless");

        //defining the web driver that you will be using
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://www.metlife.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='SOLUTIONS']")).click();
        //click on tak along  dental link
        driver.findElement(By.xpath("//*[text()='MetLife TakeAlong Dental']")).click();
        Thread.sleep(1500);
        //click to enroll now button
        driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
        //need to store get window handles command in as Arraylist to switch to different tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch the second tab
        driver.switchTo().window(tabs.get(1));
        //enter the zipcode
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='txtZipCode']")).sendKeys("11218");

        Thread.sleep(1000);
        driver.close();//to close the new tab if you don't need again
        //switch back to previous tab
        driver.switchTo().window(tabs.get(0));
        //navigate back to metlife
        driver.navigate().to("http://www.metlife.com");





    }//end method
}//end java
