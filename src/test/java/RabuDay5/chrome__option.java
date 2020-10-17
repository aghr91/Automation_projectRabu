package RabuDay5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chrome__option {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver();


        //let's navigate to google home page
        System.out.println("Navigate to google home page");
        driver.navigate().to("http://www.google.com");
        Thread.sleep(3000);

        //
        String actualTitle = driver.getTitle();
        //
        if (actualTitle == "GOOGLE") {
            System.out.println("Tittle matches ");
        }else{
            System.out.println(("Tittle doesn't match. Actual tittle is " + actualTitle));

        }//end conditional statement
    }//end method
}//end java
