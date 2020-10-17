package Actionitem;

import Rabu2nd.Reusable_Method;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Wight_Watchers {

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

        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11218");
        zipcode.add("11235");
        zipcode.add("11229");
        
        for (int i = 0; i < zipcode.size(); i++) {
            driver.navigate().to("https://www.weightwatchers.com/us/");
            Thread.sleep(1500);
            String actualTitle = driver.getTitle();
            //
            if (actualTitle == "Weight Watchers: Weight Loss & Wellness Help ") {
                System.out.println("Tittle matches ");
            } else {
                System.out.println(("Tittle doesn't match. Actual tittle is " + actualTitle));
            }//e// nd conditional statement
            Thread.sleep(2000);
            // find a workshop
            try {
                System.out.println("clicking on find a workshop");
                driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']")).click();
            }catch(Exception err) {
                System.out.println("Unable to click find a workshop" + err);
            }
            try {
                //driver.findElement(By.xpath("//*[@id='location-search']"))
                WebElement zip = driver.findElement(By.xpath("//*[@id='location-search']"));
                zip.clear();
                zip.sendKeys(zipcode.get(i));
                zip.submit();


            }catch (Exception err){
                System.out.println("unable to enter zipcode" + err);
            }
            Thread.sleep(2500);
            //searching first link
            if (i==0) {
                try {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();
            }catch (Exception err){
                    System.out.println("unable to find link" + err);

                }
            }//
            Thread.sleep(2500);
            if (i==1) {
                try {
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();
                }catch (Exception err){
                    System.out.println("unable to find link" + err);

                }
            }//
            if (i==2) {
            try {
                driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();
            }catch (Exception err){
                System.out.println("unable to find link" + err);

            }
        }//
            try {
                String address1 = driver.findElement(By.xpath("//*[@class='locationName-1jro_']")).getText();
                String address2 = driver.findElement(By.xpath("//*[@class='oneLine-1Py5V']")).getText();
                String address3 = driver.findElement(By.xpath("//*[@class='oneLine-1Py5V']")).getText();
                System.out.println("my address is" +address1 + " " + address2 + " " +address3);


            }catch (Exception err){
                System.out.println("unable to locate the address" + err);
            }
            //
            Thread.sleep(2500);
            JavascriptExecutor Jse = (JavascriptExecutor) driver;
            //scroll down using executeScript command
            Jse.executeScript("scroll(0,5000)");
            //capture the entire footer including the result from yahoo result page
           try {

               String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
               System.out.println("The schedule is the following:" +schedule);
           }catch (Exception err){
               System.out.println("Unable to find schedule"+ err);
           }


        }//for loop
        driver.quit();
    }//end method
}//java