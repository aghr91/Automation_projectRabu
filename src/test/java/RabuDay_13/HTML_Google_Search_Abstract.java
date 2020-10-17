package RabuDay_13;

import Reusable_Library.Abstract_Class;
import Reusable_Library.Reusable_Method_logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HTML_Google_Search_Abstract extends Abstract_Class {
    @Test
    public void Google_Search() throws InterruptedException {
        logger.log(LogStatus.INFO, "Navigating to Google home page");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        Reusable_Method_logger.sendkeys(driver, "//*[@name='q']", "Cars", logger, "Search Field");
        Reusable_Method_logger.submit(driver, "//*[@name='btnK']", logger, "Search Button");
        Thread.sleep(2000);
        //test

    }//end test

    @Test(dependsOnMethods = "Google_Search")
    public void Google_Search_Result() throws InterruptedException {
        String result = Reusable_Method_logger.captureResult(driver,"//*[@id='result-stats']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[1]);
        //after all the test steps per @Test you must end the test as well
    }//end of test


}//
