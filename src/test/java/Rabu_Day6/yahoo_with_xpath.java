package Rabu_Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class yahoo_with_xpath {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver();
        //navigate to yahoo page
        driver.navigate().to("http://www.yahoo.com");
        Thread.sleep(2000);
        //type a keyword on yahoo search field
        driver.findElement(By.xpath("//*[@name='p']")).sendKeys("cars");
        //click/submit on search button
        driver.findElement(By.xpath("//*[@value='Search]']")).click();
        //delay 2 seconds
        Thread.sleep(2000);
        //need to scroll to the bottom of the page to capture the search result
        JavascriptExecutor Jse = (JavascriptExecutor) driver;
        //scroll down using executeScript command
        Jse.executeScript("scroll(0,5000)");
        //capture the entire footer including the result from yahoo result page
         String result = driver.findElement(By.xpath("//*[@class='comPagination']")).getText();
        //need to split by next to separate the search result
        String[] arrayResult = result.split("Next");
        //need to split again to only capture the number
        String[] searchResult = arrayResult[1].split(" ");
        //print out the number you are looking for
        System.out.println("my search number is" + searchResult[0]);
        driver.quit();


    }//end method

}//end java
