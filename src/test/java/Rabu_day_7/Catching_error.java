package Rabu_day_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Catching_error {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");
        //defining the WebBrowser you will be using

        WebDriver driver = new ChromeDriver(options);
        //navigate to mlcalc page
        driver.navigate().to("http://www.mlcalc.com");
        //

        Thread.sleep(2000);


        //clear and enter purchase price
        try{
            WebElement pPrice = driver.findElement(By.xpath("//*[@name= 'ma']"));
            pPrice.clear();
            pPrice.sendKeys("4000000");
        }catch  (Exception err){
            System.out.println("Unable to enter value on Purchase price" +err);

        }//end of the purchase price Exception
        //
        try{
            WebElement dPayment = driver.findElement(By.xpath("//*[@name= 'dp']"));
            dPayment.clear();
            dPayment.sendKeys("40");
        }catch (Exception err) {
            System.out.println("Unable to enter value on Purchase price" + err);

        }//end of down payment exception
        try{
            WebElement starMonth = driver.findElement(By.xpath("//*[@name= 'sm']"));
            Select smList = new Select(starMonth);
            smList.selectByVisibleText("Feb");
        }catch (Exception err) {
            System.out.println("Unable to select start month" + err);
        }//end starMonth
        //calculate
        try{
             driver.findElement(By.xpath("//*[@alt= 'Calculate']")).click();
        }catch (Exception err) {
            System.out.println("Unable to click on calculate button" + err);
        }//end calculate exception




        }//end class
}//end java
