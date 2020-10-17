package Rabu_Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath_Concepts {

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
        //locate search field by id or name

        driver.findElement(By.xpath("//*[@id='ybar-sbq' or @name='p']")).sendKeys("cars");
        driver.navigate().to("http://www.yahoo.com");
        Thread.sleep(2000);
        //using contains to only specify matching word within a property to locate an element
        driver.findElements(By.xpath("//*[contains(@class,'yb_e4mte')]")).get(2).click();

    }//end main method
}//end java class
