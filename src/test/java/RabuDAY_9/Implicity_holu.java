package RabuDAY_9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Implicity_holu {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to holu.com page
        driver.navigate().to("http://www.holu.com");
        Thread.sleep(2000);
        //click start free trail
        //driver.findElement(By.xpath("//*[text()='START YOUR FREE TRAIL']")).click();
        //PROPERTY IS NOT WORK because element interactable
        //use another property
        driver.findElement(By.xpath("//*[@class='button--cta button--white Masthead__input-cta']")).click();

    }//end method
}//end java
