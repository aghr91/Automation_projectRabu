package Last_Assignment;

import Reusable_Library.Abstract_Class_Cross_Browser;
import Reusable_Library.Reusable_Method_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class HTML_Fedex_Search_logger_Crossbrowser extends Abstract_Class_Cross_Browser {

    @Test
    public void Fedex_search() throws InterruptedException {
        driver.manage().deleteAllCookies();

        logger.log(LogStatus.INFO,"Navigating to fedex home page");
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        Thread.sleep(2000);


        Reusable_Method_logger.click(driver,"//*[@data-analytics='hdr|tab|3|design & print']",logger,"Design & Print tab");
        Reusable_Method_logger.click(driver,"//*[@alt='Upload a Print-Ready File']",logger,"Upload & Print ready File");
        Thread.sleep(1500);
        String actualTitle = driver.getTitle();
        //
        if (actualTitle.contains("Fedex Office Print")) {
            logger.log(LogStatus.PASS, "Title matches", actualTitle);
        } else {
            logger.log(LogStatus.FAIL,"Title doesn't match" + actualTitle);
        }//end of verify
        Reusable_Method_logger.click(driver,"//*[@src='../../images/us/office/easyprint/config/images/new-product-picker-tiles/presentation.jpg']",logger,"Document printing");
        //usable_Method_logger.click_popup(driver,"//*[@href='javascript:ipe125413.clWin()']",logger,"Pop up");

        Reusable_Method_logger.click(driver,"//*[@src='../../images/us/office/easyprint/config/images/svg/custom.svg']",logger,"Copies & Customs Projects");
        Reusable_Method_logger.click(driver,"//*[@name='upload-files-button']",logger,"Use Your File");
        Thread.sleep(4000);
        Reusable_Method_logger.uploadFile("C:\\Users\\Rabu hossain\\OneDrive\\Desktop\\Maven_Automation\\src\\main\\resources\\download.jpg");
        Thread.sleep(3000);
        Reusable_Method_logger.click(driver,"//*[@id='js-modal__continue-btn_lowResolutionPreview']",logger,"Continue as Existing");
        Thread.sleep(2000);
        Reusable_Method_logger.sendkeys(driver,"//*[@class='quantity-field']","5",logger,"Quantity");
        Reusable_Method_logger.click(driver,"//*[@name='update_quanity-addToCart-lbl']",logger,"Add to Cart");
        Thread.sleep(4000);
        Reusable_Method_logger.click(driver,"//*[text()='Checkout']",logger,"CheckOut");
        Thread.sleep(4000);
        Reusable_Method_logger.click(driver,"//*[@id='continueAsGuest']",logger,"Proceed As a Guest");
        Thread.sleep(2000);
        Reusable_Method_logger.dropDownMenu(driver,"//*[@id='radiusSelect']","5 Miles",logger,"Selecting Miles");
        Thread.sleep(2000);
        Reusable_Method_logger.typeAndSubmit(driver,"//*[@id='loc_seacrh_text']","11235",logger,"Entering ZipCode");
        Thread.sleep(2000);
        String address = Reusable_Method_logger.captureResult(driver,"//*[@class='active']",logger,"Capture Address");
        System.out.println("Capturing the Address" + address);
        Thread.sleep(3000);

    }//end of test

}//end of java

