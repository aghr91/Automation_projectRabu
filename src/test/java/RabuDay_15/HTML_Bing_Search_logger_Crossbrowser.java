package RabuDay_15;

import Reusable_Library.Abstract_Class_Cross_Browser;
import Reusable_Library.Reusable_Method_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HTML_Bing_Search_logger_Crossbrowser extends Abstract_Class_Cross_Browser {
    @Test
    public void Bing_Search() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigating to Bing home page");
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2000);
        Reusable_Method_logger.sendkeys(driver,"//*[@name='q']","Cars",logger,"Search Field");
        Reusable_Method_logger.submit(driver,"//*[@id='sb_form_go']",logger,"Search Button");
        Thread.sleep(2500);
        String result = Reusable_Method_logger.captureResult(driver,"//*[@class='sb_count']",logger,"Search Result");
        String[] arrayResult = result.split(" ");
        logger.log(LogStatus.PASS,"My search number is " + arrayResult[0]);
        //after all the test steps per @Test you must end the test as well
    }//end of test



}//end of java class
