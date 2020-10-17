package Rabu_day_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class micalc_with_for_loop {
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

        //set the value for purchase price Arraylist
        ArrayList<String> pPriceList = new ArrayList<>();
        pPriceList.add("530000");
        pPriceList.add("5500000");
        //set the value for down payment array list
        ArrayList<String> dPaymentList = new ArrayList<>();
        dPaymentList.add("30");
        dPaymentList.add("50");
        //call the for loop to iterate through the array list
        for (int i = 0; i < pPriceList.size(); i++) {
            driver.navigate().to("http://www.mlcalc.com");
            Thread.sleep(2000);
            //clear and enter purchase price
            try{
                System.out.println("Entering new value of purchase price");
                WebElement pPrice = driver.findElement(By.xpath("//*[@name= 'ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
            }catch  (Exception err){
                System.out.println(" Unable to enter value  on Purchase price" +err);

            }//end of the purchase price Exception
            //clear and enter down payment
            try{
                System.out.println("Entering new value on down payment");
                WebElement dPayment = driver.findElement(By.xpath("//*[@name= 'dp']"));
                dPayment.clear();
                dPayment.sendKeys(dPaymentList.get(i));
            }catch (Exception err) {
                System.out.println(" unable to enter value on dPayment " + err);

            }//end of down payment exception

            //clicking on calculate button
            try{
                System.out.println("Clicking on Calculate button");
                driver.findElement(By.xpath("//*[@alt= 'Calculate']")).click();
            }catch (Exception err) {
                System.out.println("Unable to click on calculate button" + err);
            }//end calculate exception
            Thread.sleep(25000);
            //capture and print monthly payment
            try{
                System.out.println("capturing monthly payment");
                String mntPayment =driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
                System.out.println("my monthly payment is" + mntPayment);
            }catch (Exception err) {
                System.out.println("Unable to capture the monthly payment " + err);
            }//end opf monthly payment exception


        }//end loop

    }//method
}//end java
