package Rabu_day_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Array_List {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        ArrayList<String> smList = new ArrayList<>();
        smList.add("Oct");
        smList.add("Sep");
        smList.add("Aug");
        smList.add("Nov");
        smList.add("Feb");
        smList.add("Jan");
        smList.add("Apl");

        //navigate to mlcalc page
        driver.navigate().to("http://www.mlcalc.com");
        Thread.sleep(2000);
        //using loop i want to iterate through all month list and click on each one
        for (int i = 0; i < smList.size(); i++) {
            //use WebElement variable to store your start month dropdown
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select smDropdown = new Select(startMonth);
            smDropdown.selectByVisibleText(smList.get(i));

            //selecting start month when the html tag is not under select tag
            driver.findElement(By.xpath("//*[@name='sm']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[text()='" +smList.get(i)+"']")).click();



        }//end loop
    }//end method
}//end java
