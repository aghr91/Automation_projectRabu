package Actionitem;

import Reusable_Library.Reusable_method;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestNG_Kayak {
    //declare all the global variables outside
    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    @BeforeSuite
    public void setDriver() throws IOException, BiffException {
        //setting the chrome driver
        driver = Reusable_method.getDriver();
        //Step 1: locate the readable excel workbook
        readableFile = Workbook.getWorkbook(new File("src/main/resources/Kayak_Info.xls"));
        //Step 2: locate the excel sheet for this readable workbook
        readableSheet = readableFile.getSheet(0);
        //Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        writableFile = Workbook.createWorkbook(new File("src/main/resources/Kayak_Info_Results.xls"), readableFile);
        //Step 4: define the writable sheet for writable file
        writableSheet = writableFile.getSheet(0);
        //Ste 5: get the count of the rows that are not empty on your excel workbook
        rowCount = writableSheet.getRows();
    }//end of before suite


    @Test
    public void getTotalPrice() throws WriteException, InterruptedException {
        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {
            //I need to get the content of the cell
            //column is hard coded and row is dynamic(i)
            String airport = writableSheet.getCell(0, i).getContents();
            String StarDate = writableSheet.getCell(1, i).getContents();
            String StartTime = writableSheet.getCell(2, i).getContents();
            String EndDate = writableSheet.getCell(3, i).getContents();
            String EndTime = writableSheet.getCell(4, i).getContents();
            String VehicleSize = writableSheet.getCell(5, i).getContents();

            //navigate to Kayak home page
            driver.navigate().to("https://www.Kayak.com");
            String actualTitle = driver.getTitle();
            //
            if (actualTitle == "KAYAK") {
                System.out.println("Tittle matches ");
            } else {
                System.out.println(("Tittle doesn't match. Actual tittle is " + actualTitle));
            }//
            Thread.sleep(2000);
            Reusable_method.typeAndSubmit(driver, "//*[@name='pickup']", airport, "Airport");


            //line below is click on calendar icon first for start date
            Reusable_method.click(driver, "//*[contains(@id,'dateRangeInput-display-start-inner')]", "Start Date");
            Reusable_method.typeAndSubmit(driver, "//*[contains(@id,'pickup-date-input')]", StarDate, "Start Date");
            // element below is not interactable because you have to close the calendar so click anywhere outside
            //like clicking on title search for hundred
            Reusable_method.click(driver, "//*[contains(@id,'HpiZ')]", "");
            //end date

            Reusable_method.click(driver, "//*[contains(@id,'HpiZ-dateRangeInput-display-end-inner')]", "End Date");
            Reusable_method.typeAndSubmit(driver, "//*[contains(@id,'dropoff-date-input')]", EndDate, "End Date");
            //like clicking on title search for hundred

            Reusable_method.click(driver, "//*[contains(@id,'HpiZ')]", "");

            //before you select the value from start time you need to click on start time icon first
            Reusable_method.click(driver, "//*[contains(@id,'start-time-select-display')]", "Start Time");
            // also before clicking on the value you should put 1.5 to 2 seconds to slow down selenium
            // or else you will get element not interactable error
            Thread.sleep(2500);
            //now click on start time value
            Reusable_method.mouseClick(driver, "//*[contains(@id,'start-time-select-option') and @data-title='1:00 am']", "Start Time Value");


            //End time
            Reusable_method.click(driver, "//*[contains(@id,'end-time-select-display')]", "End Time");
            Thread.sleep(2500);
            Reusable_method.mouseClick(driver, "//*[contains(@id,'end-time-select-option') and @data-title='3:00 am']", "End Time Value");

            //click on search icon
            Reusable_method.click(driver, "//*[@class='_h-2 _ivP _iv1']", "Search Icon");
            Thread.sleep(1500);
            //Vehicle size
            Reusable_method.click(driver, "//*[@class='MPti']", "Vehicle Size");
            Reusable_method.clickByIndex(driver, "//*[class='button']", 2, "Third deal");
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch the second tab
            driver.switchTo().window(tabs.get(1));
            //enter the zipcode
            Thread.sleep(2000);
            //capture total price
            String result = Reusable_method.captureResult(driver, "//*[@class='fpiCell']/following::dd[contains(text(),'$')]", "Total Price");
            System.out.println("The Total Price is " + result);

            //store and send it to the empty column in excel writable file
            Label label = new Label(6, i, result);
            //adding this label to the writable sheet
            writableSheet.addCell(label);
            driver.switchTo().window(tabs.get(1));
            driver.close();

        }//end of for loop
    }//end test
        @AfterSuite
        public void closingInfo() throws IOException, WriteException {
            writableFile.write();
            writableFile.close();
            driver.quit();
        }//end afterSuite



        //   Reusable_method.click(driver,"//*[@class='title dark']","Dark Title");
        //put like 1 second
       // Thread.sleep(1000);
//now do the same for calendar end date by choosing accurate property

//after entering end date you can click outside to close the calendar
//Reusable_Methods.click(driver,"//*[@class='title dark']","Dark Title");

//then same click end time first

//wait few seconds then click on end time value



}//end of java class
