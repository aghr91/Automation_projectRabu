package Actionitem;

import Rabu_day_7.Array_List;
import Reusable_Library.Reusable_method;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Assignment_5_ReusableMethod {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //settings the chrome option before the Webdriver
        ChromeOptions options = new ChromeOptions();
        //set the driver in maximized mode
        options.addArguments("start-maximized");
        //set the driver in incognito mode
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);
        //ArrayList for FirstNames
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Mohammad");
        firstName.add("Abdul");
        firstName.add("john");

        //ArrayList for LastNames
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Hossain");
        lastName.add("Khan");
        lastName.add("Ahmed");

        //arraylist for death of birth
        ArrayList<String> month = new ArrayList<>();
        month.add("June");
        month.add("july");
        month.add("August");
        ArrayList<String> day = new ArrayList<>();
        day.add("15");
        day.add("20");
        day.add("18");
        ArrayList<String> year = new ArrayList<>();
        year.add("1991");
        year.add("1993");
        year.add("2015");
        //last 6 digit of social security number
        ArrayList<String> SSN = new ArrayList<>();
        SSN.add("123456");
        SSN.add("123746");
        SSN.add("130646");

        //arraylist for zipcode
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11235");
        zipcode.add("11655");
        zipcode.add("11334");

        for (int i = 0; i < firstName.size(); i++) {
            //navigate to UHC.com page
        driver.navigate().to("http://www.UHC.com");
        Thread.sleep(2000);
        //
        String actualTitle = driver.getTitle();
        if (actualTitle == "Health insurance plans") {
            System.out.println("Tittle matches ");
        } else {
            System.out.println(("Tittle doesn't match. Actual tittle is " + actualTitle));
            //calling the reusable click method for find a plan
            // Reusable_method.click(driver,"//*[text()='Find Your Plan']","find plan");
            // Thread.sleep(2000);
            //using reusable method find a doctor
            Reusable_method.click(driver, "//*[@aria-label='Find a Doctor']", "find a doctor");
            //calling reusable method sign in to find provider
            Reusable_method.click(driver, "//*[@id='btn-sign-in']", "find a provider");
            Thread.sleep(2000);

            //need to store get window handles command in as Arraylist to switch to different tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch the second tab
            driver.switchTo().window(tabs.get(1));
            //enter the zipcode
            Thread.sleep(2000);

            //using reusable method for register
            Reusable_method.click(driver, "//*[@class='btn btn-outline-primary btn-block']", "register now");
            Thread.sleep(2000);
            //

                Reusable_method.sendkeys(driver, "//*[@id='firstName']", firstName.get(i), "first name");
                Thread.sleep(2000);
                Reusable_method.sendkeys(driver, "//*[@id='lastName']", lastName.get(i), "Last name");
                Thread.sleep(2000);
                Reusable_method.dropDownMenu(driver, "//*[@id='dob_month_input']", month.get(i), "Month");
                Thread.sleep(1000);
                Reusable_method.sendkeys(driver, "//*[@id='dob_day']", day.get(i), "Day");
                Thread.sleep(1000);
                Reusable_method.sendkeys(driver, "//*[@id='dob_year']", year.get(i), "Year");

                //scroll down

                JavascriptExecutor Jse = (JavascriptExecutor) driver;
                //scroll down using executeScript command
                Jse.executeScript("scroll(0,500)");
                Thread.sleep(1000);
                //ssn
                Reusable_method.click(driver, "//*[@id='ssn_container']", "social security number");
                Thread.sleep(2000);
                Reusable_method.sendkeys(driver, "//*[@id='ssnLastSixDigits']", SSN.get(i), "SSN");
                Thread.sleep(2000);
                //zipcode
                Reusable_method.sendkeys(driver, "//*[@id='zipCode']", zipcode.get(i), "Entering zipcode");
                Thread.sleep(2000);
                //click on continue button
                Reusable_method.click(driver, "//*[@id='submitBtn']", "click continue");
                //
                Reusable_method.captureResult(driver, "//*[@id='plainText_error']", "Error message");
                driver.close();
                driver.switchTo().window(tabs.get(0));


            }//end of for loop
            driver.quit();
        }//end of main method

    }
    }//end of java class

