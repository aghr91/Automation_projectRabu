package Rabu_day_11;

import Reusable_Library.Reusable_method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testing_Google_Search {

    //call before suite to set up your chromedriver
    //precondition
    //driver need to be initialized outside of all method so it can reusable

    WebDriver driver = null;
    @BeforeSuite
    public void setChromeDriver(){
        driver = Reusable_method.getDriver();
    }//end of before suite

    @Test(priority = 1)
    public void searchKeyword() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        Reusable_method.sendkeys(driver,"//*[@name='q']","Cars","Search Field");
        Reusable_method.submit(driver,"//*[@name='btnK']","Search Button");
        Thread.sleep(2000);
    }//end of test 1

    @Test(priority = 2)
    public void getSearchResult(){
        String result = Reusable_method.captureResult(driver,"//*[@id='result-stats']","Result");
        System.out.println("My Search result is " + result);
    }//end of test 2

    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }//end of after suite







}//end java
