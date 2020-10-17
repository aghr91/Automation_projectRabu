package Actionitem;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Method_logger;
import Reusable_Library.Reusable_method;
import com.relevantcodes.extentreports.ExtentTest;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Month;

public class Abstract_Express_Search extends Abstract_Class {


    @Test
    public void Express_Search() throws IOException, BiffException, InterruptedException, WriteException {

        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_Info.xls"));
        //Step 2:locate the excel sheet for this readable workbook
        Sheet readableSheet = readableFile.getSheet(0);
        // Step 3: make a copy of readable file to write back to the excel so it doesn't corrupt the original file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_Info_Results.xls"), readableFile);
        //Step 4: define the sheet for writable file
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Step 5: get the count of the rows that are not empty on your excel workbook
        int rowCount = writableSheet.getRows();

        //all the test steps have to go inside for loop
        for (int i = 1; i < rowCount; i++) {
            //i need to get the content of the cell
            //column is hard coded and row is dynamic (i)
            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String FirstName = writableSheet.getCell(2, i).getContents();
            String Lastname = writableSheet.getCell(3, i).getContents();
            String Email = writableSheet.getCell(4, i).getContents();
            String PhoneNumber = writableSheet.getCell(5, i).getContents();
            String Address = writableSheet.getCell(6, i).getContents();
            String Zipcode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String CardNumber = writableSheet.getCell(10, i).getContents();
            String ExpireMonth = writableSheet.getCell(11, i).getContents();
            String ExpireYear = writableSheet.getCell(12, i).getContents();
            String Cvv = writableSheet.getCell(13, i).getContents();
            String ErrorMessage = writableSheet.getCell(14, i).getContents();

            driver.manage().deleteAllCookies();


            //navigate the mortgage home
            driver.navigate().to("http://www.express.com");
            Thread.sleep(1000);
            String actualTitle = driver.getTitle();
            //
            if (actualTitle.contains("Men's and Women's Clothing")) {
                System.out.println("Tittle matches ");
            } else {
                System.out.println(("Tittle doesn't match. Actual tittle is " + actualTitle));
            }//end verify page
            Thread.sleep(1000);
            //Enter
            Reusable_Method_logger.mouseHover(driver, "//*[contains(@href,'/mens-clothing')]",logger, "Mens");
            Reusable_Method_logger.click(driver, "//*[@href='/mens-clothing/shirts/cat410008']", "Shirt link");
            Thread.sleep(1000);
            JavascriptExecutor Jse = (JavascriptExecutor) driver;
            //scroll down using executeScript command
            Jse.executeScript("scroll(0,500)");
            Thread.sleep(1000);
            Reusable_Method_logger.clickByIndex(driver,"//*[@class='_1ddDj _136PD']", 2, logger,"Third Image");
            Thread.sleep(2000);
            Reusable_Method_logger.click(driver,"//*[@value='"+Size+"']","Size");
            Thread.sleep(1500);
            Reusable_Method_logger.click(driver,"//*[contains(text(),'Add to Bag')]","Add to Bag");
            Reusable_Method_logger.mouseHover(driver,"//*[text()='View Bag']", logger, "View Bag Tab");
            Reusable_Method_logger.mouseClick(driver,"//*[text()='View Bag']", logger, "View Bag Tab");
            Thread.sleep(1500);
            Reusable_Method_logger.dropDownMenu(driver,"//*[@id='qdd-0-quantity']", Quantity,logger,"Select dropdown");
            Reusable_Method_logger.click(driver,"//*[@id='continue-to-checkout']","Check Out");
            Reusable_Method_logger.click(driver,"//*[text()=Checkout as Guest]","Check out As a Guest");
            Thread.sleep(1000);
            Reusable_Method_logger.sendkeys(driver,"//*[@id='contact-information-firstname']",FirstName,logger,"First Name");
            Reusable_Method_logger.sendkeys(driver,"//*[@name='lastname']",Lastname,logger,"Last Name");
            Reusable_Method_logger.sendkeys(driver,"//*[@name='email']",Email,logger,"Email");
            Reusable_Method_logger.sendkeys(driver,"//*[@name='confirmEmail']",Email,logger,"Confirm Email");
            Reusable_Method_logger.sendkeys(driver,"//*[@name='phone']",PhoneNumber,logger,"Phone Number");
            Reusable_Method_logger.click(driver,"//*[@type='submit']","Click");
            Thread.sleep(1000);
            Reusable_Method_logger.sendkeys(driver,"//*[@name='shipping.line1']",Address,logger,"Address");
            Reusable_Method_logger.sendkeys(driver,"//*[@name='shipping.postalCode']",Zipcode,logger,"Zipcode");
            Reusable_Method_logger.sendkeys(driver,"//*[@name='shipping.city']",City,logger,"City");
            Reusable_Method_logger.dropDownMenu(driver,"//*[@name='shipping.state']",State,logger,"State");
            Reusable_Method_logger.click(driver,"//*[@type='submit']","Click");
            Reusable_Method_logger.click(driver,"//*[@type='submit']","Click");
            Thread.sleep(1000);
            Reusable_Method_logger.sendkeys(driver,"//*[@name='creditCardNumber']",CardNumber,logger,"Card Number");
            Reusable_Method_logger.dropDownMenu(driver,"//*[@name='expMonth']",ExpireMonth,logger,"Expire Month");
            Reusable_Method_logger.dropDownMenu(driver,"//*[@name='expYear']",ExpireYear,logger,"Expire Year");
            Reusable_Method_logger.sendkeys(driver,"//*[@name='cvv']",Cvv,logger,"CVV");
            Reusable_Method_logger.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC _1uOkR']","Place order");
            Thread.sleep(2000);

            String Error=Reusable_Method_logger.captureResult(driver,"//*[text()='Enter a valid credit card number.']",logger,"Error Message");
            System.out.println("The error is" + Error);
            //store and send it to the empty column in excel writable file
            Label label = new Label(14, i, Error);
            //adding this label to the writable sheet
            writableSheet.addCell(label);







        }//End of for loop
        writableFile.write();
        writableFile.close();
        driver.quit();


    }//end of test
}//end of abstract class
