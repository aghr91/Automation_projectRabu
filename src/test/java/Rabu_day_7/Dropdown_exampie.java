package Rabu_day_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_exampie {
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
        driver.navigate().to("http://www.mlcalc.com");
        //

        Thread.sleep(2000);

        //use WebElement variable to store your start month dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select smDropdown = new Select(startMonth);
        smDropdown.selectByVisibleText("feb");
        //selecting start month when the html tag is not under select tag
        driver.findElement(By.xpath("//*[@name='sm']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//[text()='feb']")).click();


        //use WebElement variable to store your start month dropdown
        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        Select syDropdown = new Select(startYear);
        syDropdown.selectByVisibleText("2022");


    }//main method
}//end of the class
