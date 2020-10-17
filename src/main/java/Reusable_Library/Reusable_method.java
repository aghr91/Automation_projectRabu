package Reusable_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_method {
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver86.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
    //reusable method to click on any element on any websites
    public static void click(WebDriver driver, String locator, String elementName) {

        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            System.out.println("Clicking on element" + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();

        } catch (Exception err) {
            System.out.println("Unable to click on element");
        }//end exception
    }//end of click


    //Method for entering values
    public static void sendkeys(WebDriver driver, String locator, String userValue, String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            System.out.println("Typing on element" + elementName);

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to type on element");
        }//end exception
    }//end of sendkeys


    //reusable method to submit on any element on any websites
    public static void submit(WebDriver driver, String locator,String elementName) {
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);

        try {
            System.out.println(" submitting on element" + elementName);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).submit();

        } catch (Exception err) {
            System.out.println("Unable to submit on element" + err);




            }//end exception
        }//end of submit

    // capturing the value
    public static String captureResult (WebDriver driver, String locator, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = "";
        try {
            System.out.println("Capturing the element" + elementName);
          result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).getText();
          System.out.println(result);


        }catch (Exception err){
            System.out.println("Unable to capture " +err);


        }//end of exception
        return result;
        
    }//end of capturing

    // method to select from drop down menu
    public static void dropDownMenu (WebDriver driver, String locator, String dropDownOption, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            System.out.println("selecting" + elementName);
            WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            Select selectDropDown = new Select(dropDown);
            selectDropDown.selectByVisibleText(dropDownOption);
        }catch (Exception err){
            System.out.println("Unable to select from drop down menu");
        }//end Exception

    }//end dropdown


    public static void clickByIndex(WebDriver driver,String locator,int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,9);
        try{
            System.out.println("Clicking by index " + index + " on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception err) {
            System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + err);
        }
    }//end of click by index method

    public static void typeAndSubmit(WebDriver driver,String locator, String userInput, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            System.out.println("Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(userInput); //this is another way to submit to an element using key event
        } catch (Exception err) {
            System.out.println("Unable to enter on element " + elementName + " " + err);
        }
    }//end of type and submit method


    //method to click on an element
    public static void mouseClick(WebDriver driver,String locator,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to mouse click element " + elementName + " " + e);
        }
    }//end of click method











}//end method

