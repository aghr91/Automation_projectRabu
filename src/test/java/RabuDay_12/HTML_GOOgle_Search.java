package RabuDay_12;

import Reusable_Library.Reusable_Method_logger;
import Reusable_Library.Reusable_method;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HTML_GOOgle_Search {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    @BeforeSuite
    public void setDriver(){
        driver = Reusable_method.getDriver();

        //define where you want to save the report(path)
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html",true);

    }//end of before suite

    @Test
    public void Google_Search() throws InterruptedException {
        logger = reports.startTest("Google Search Result");
        logger.log(LogStatus.INFO,"Navigating to Google home page");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        Reusable_Method_logger.sendkeys(driver,"//*[@name='q']","cars",logger,"Search Field");
        Reusable_Method_logger.submit(driver,"//*[@name='btnK']",logger,"Search Button");
        Thread.sleep(2000);
        String result = Reusable_Method_logger.captureResult(driver,"//*[@id='result-stats']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[1]);
        //after all the test steps per @Test you must end the test as well
        reports.endTest(logger);
    }//end of test

    @AfterSuite
    public void closeSession(){
        reports.flush();
        //driver.quit();

    }//end of after suite


}//end of java class




